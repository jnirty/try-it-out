package com.example.security.acl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.acls.AclEntryVoter;
import org.springframework.security.acls.domain.ObjectIdentityRetrievalStrategyImpl;
import org.springframework.security.acls.domain.SidRetrievalStrategyImpl;
import org.springframework.security.acls.model.Acl;
import org.springframework.security.acls.model.AclService;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.security.acls.model.ObjectIdentity;
import org.springframework.security.acls.model.ObjectIdentityRetrievalStrategy;
import org.springframework.security.acls.model.Permission;
import org.springframework.security.acls.model.Sid;
import org.springframework.security.acls.model.SidRetrievalStrategy;
import org.springframework.security.core.Authentication;
import org.springframework.util.StringUtils;

public class CustomAclEntryVoter extends AclEntryVoter {
	private Logger logger = Logger.getLogger(CustomAclEntryVoter.class);
	private ObjectIdentityRetrievalStrategy objectIdentityRetrievalStrategy = new ObjectIdentityRetrievalStrategyImpl();
    private SidRetrievalStrategy sidRetrievalStrategy = new SidRetrievalStrategyImpl();
	private AclService aclService;
	private List<Permission> requirePermission;
    public CustomAclEntryVoter(AclService aclService, String processConfigAttribute, Permission[] requirePermission) {
		super(aclService, processConfigAttribute, requirePermission);
		this.aclService = aclService;
		this.requirePermission = Arrays.asList(requirePermission);
	}

	@Override
	public int vote(Authentication authentication, MethodInvocation object, Collection<ConfigAttribute> attributes) {

		for (ConfigAttribute attr : attributes) {

			if (!this.supports(attr)) {
				continue;
			}
			// Need to make an access decision on this invocation
			// Attempt to locate the domain object instance to process
			Object domainObject = getDomainObjectInstance(object);

			// If domain object is null, vote to abstain
			if (domainObject == null) {
				if (logger.isDebugEnabled()) {
					logger.debug("Voting to abstain - domainObject is null");
				}

				return ACCESS_ABSTAIN;
			}

			// Evaluate if we are required to use an inner domain object
			if (StringUtils.hasText(getInternalMethod())) {
				try {
					Class<?> clazz = domainObject.getClass();
					Method method = clazz.getMethod(getInternalMethod(), new Class[0]);
					domainObject = method.invoke(domainObject);
				} catch (NoSuchMethodException nsme) {
					throw new AuthorizationServiceException("Object of class '" + domainObject.getClass() + "' does not provide the requested internalMethod: " + getInternalMethod());
				} catch (IllegalAccessException iae) {
					logger.debug("IllegalAccessException", iae);

					throw new AuthorizationServiceException("Problem invoking internalMethod: " + getInternalMethod() + " for object: " + domainObject);
				} catch (InvocationTargetException ite) {
					logger.debug("InvocationTargetException", ite);

					throw new AuthorizationServiceException("Problem invoking internalMethod: " + getInternalMethod() + " for object: " + domainObject);
				}
			}

			// Obtain the OID applicable to the domain object
			ObjectIdentity objectIdentity = objectIdentityRetrievalStrategy.getObjectIdentity(domainObject);

			// Obtain the SIDs applicable to the principal
			List<Sid> sids = sidRetrievalStrategy.getSids(authentication);

			Acl acl;

			try {
				// Lookup only ACLs for SIDs we're interested in
				acl = aclService.readAclById(objectIdentity, sids);
			} catch (NotFoundException nfe) {
				if (logger.isDebugEnabled()) {
					logger.debug("Voting to deny access - no ACLs apply for this principal");
				}

				return ACCESS_DENIED;
			}

			try {
				if (acl.isGranted(requirePermission, sids, false)) {
					if (logger.isDebugEnabled()) {
						logger.debug("Voting to grant access");
					}

					return ACCESS_GRANTED;
				} else {
					if (logger.isDebugEnabled()) {
						logger.debug("Voting to deny access - ACLs returned, but insufficient permissions for this principal");
					}

					return ACCESS_DENIED;
				}
			} catch (NotFoundException nfe) {
				if (logger.isDebugEnabled()) {
					logger.debug("Voting to deny access - no ACLs apply for this principal");
				}

				return ACCESS_DENIED;
			}
		}

		// No configuration attribute matched, so abstain
		return ACCESS_ABSTAIN;
	}

}
