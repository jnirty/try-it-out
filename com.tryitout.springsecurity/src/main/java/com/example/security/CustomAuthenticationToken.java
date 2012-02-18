package com.example.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class CustomAuthenticationToken extends UsernamePasswordAuthenticationToken {
	private static final long serialVersionUID = 1L;
	private String requestSignature;

	/**
	 * Construct a new token instance with the given principal, credentials, and
	 * signature.
	 * 
	 * @param principal
	 *            the principal to use
	 * @param credentials
	 *            the credentials to use
	 * @param signature
	 *            the signature to use
	 */
	public CustomAuthenticationToken(String principal, String credentials, String signature) {
		super(principal, credentials);
		this.requestSignature = signature;
	}

	public String getRequestSignature() {
		return requestSignature;
	}

	public void setRequestSignature(String requestSignature) {
		this.requestSignature = requestSignature;
	}

}
