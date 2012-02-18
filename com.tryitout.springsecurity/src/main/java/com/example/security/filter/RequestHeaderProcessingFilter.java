package com.example.security.filter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import com.example.security.CustomAuthenticationToken;

public class RequestHeaderProcessingFilter extends AbstractAuthenticationProcessingFilter {

	private String usernameHeader = "j_username";
	private String passwordHeader = "j_password";
	private String signatureHeader = "j_signature";

	protected RequestHeaderProcessingFilter() {
		super("/j_spring_security_filter");
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse resp) throws AuthenticationException, IOException, ServletException {
		String username = req.getHeader(usernameHeader);
		String password = req.getHeader(passwordHeader);
		String signature = req.getHeader(signatureHeader);
		CustomAuthenticationToken authToken = new CustomAuthenticationToken(username, password, signature);
		return this.getAuthenticationManager().authenticate(authToken);
	}

	public String getUsernameHeader() {
		return usernameHeader;
	}

	public void setUsernameHeader(String usernameHeader) {
		this.usernameHeader = usernameHeader;
	}

	public String getPasswordHeader() {
		return passwordHeader;
	}

	public void setPasswordHeader(String passwordHeader) {
		this.passwordHeader = passwordHeader;
	}

	public String getSignatureHeader() {
		return signatureHeader;
	}

	public void setSignatureHeader(String signatureHeader) {
		this.signatureHeader = signatureHeader;
	}

}
