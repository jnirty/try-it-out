package com.example.security.acl;

import java.util.Collection;

import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.core.Authentication;

public class CustomAffirmativeBased extends AffirmativeBased {
	 /**
     * This concrete implementation simply polls all configured  {@link AccessDecisionVoter}s and grants access
     * if any <code>AccessDecisionVoter</code> voted affirmatively. Denies access only if there was a deny vote AND no
     * affirmative votes.<p>If every <code>AccessDecisionVoter</code> abstained from voting, the decision will
     * be based on the {@link #isAllowIfAllAbstainDecisions()} property (defaults to false).</p>
     *
     * @param authentication the caller invoking the method
     * @param object the secured object
     * @param configAttributes the configuration attributes associated with the method being invoked
     *
     * @throws AccessDeniedException if access is denied
     */
	@Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes)
            throws AccessDeniedException {
		System.out.println("******************** decide");
		
        int deny = 0;

        for (AccessDecisionVoter voter : getDecisionVoters()) {
            int result = voter.vote(authentication, object, configAttributes);

            if (logger.isDebugEnabled()) {
                logger.debug("Voter: " + voter + ", returned: " + result);
            }

            switch (result) {
            case AccessDecisionVoter.ACCESS_GRANTED:
                return;

            case AccessDecisionVoter.ACCESS_DENIED:
                deny++;

                break;

            default:
                break;
            }
        }

        if (deny > 0) {
            throw new AccessDeniedException(messages.getMessage("AbstractAccessDecisionManager.accessDenied",
                    "Access is denied"));
        }

        // To get this far, every AccessDecisionVoter abstained
        checkAllowIfAllAbstainDecisions();
    }
}
