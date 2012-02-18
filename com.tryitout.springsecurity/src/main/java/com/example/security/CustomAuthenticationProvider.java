package com.example.security;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomAuthenticationProvider extends DaoAuthenticationProvider {

	@Override
	public boolean supports(Class<?> authentication) {
		return (CustomAuthenticationToken.class.isAssignableFrom(authentication));
	}

	/**
	 * Checks authentication given by user with required one
	 * 
	 * @param userDetails
	 *            as retrieved from the retrieveUser(String,
	 *            UsernamePasswordAuthenticationToken) or UserCache
	 * @param authentication
	 *            the current request that needs to be authenticated
	 * @throws AuthenticationException
	 *             - AuthenticationException if the credentials could not be
	 *             validated (generally a BadCredentialsException, an
	 *             AuthenticationServiceException)
	 */
	@Override
	@SuppressWarnings("deprecation")
	protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		super.additionalAuthenticationChecks(userDetails, authentication);

		CustomAuthenticationToken customAuthentication = (CustomAuthenticationToken) authentication;
		if (customAuthentication.getRequestSignature() == null) {
			throw new BadCredentialsException(messages.getMessage("SignedUsernamePasswordAuthenticationProvider.missingSignature", "Missing request signature"), userDetails);
		}
		// calculate expected signature
		if (!customAuthentication.getRequestSignature().equals(calculateExpectedSignature(customAuthentication))) {
			throw new BadCredentialsException(messages.getMessage("SignedUsernamePasswordAuthenticationProvider.badSignature", "Invalid request signature"), userDetails);
		}
	}

	private Object calculateExpectedSignature(CustomAuthenticationToken customAuthentication) {
		return customAuthentication.getPrincipal() + "|+|" + customAuthentication.getCredentials();
	}
}
