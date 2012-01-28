package com.example.security;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.rememberme.InvalidCookieException;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;

public class IPTokenBasedRememberMeSevices extends TokenBasedRememberMeServices {

	private static final ThreadLocal<HttpServletRequest> requestHolder = new ThreadLocal<HttpServletRequest>();
	private static final Logger logger = Logger.getLogger(IPTokenBasedRememberMeSevices.class);

	public void setContext(HttpServletRequest request) {
		requestHolder.set(request);
	}

	public HttpServletRequest getContext() {
		return requestHolder.get();
	}

	@Override
	public void onLoginSuccess(HttpServletRequest request, HttpServletResponse response, Authentication successfulAuthentication) {
		logger.debug("onLoginSuccess - begin");
		try{
			setContext(request);
			super.onLoginSuccess(request, response, successfulAuthentication);
		}finally{
			setContext(null);
		}
		logger.debug("onLoginSuccess - end");
	}

	@Override
	protected String makeTokenSignature(long tokenExpiryTime, String username, String password) {
		logger.debug("makeTokenSignature - begin/end");
		return DigestUtils.md5Hex((tokenExpiryTime + ":" + password + ":" + getKey() + ":" + getUserIpAddress(getContext())).getBytes());
	}

	@Override
	protected void setCookie(String[] tokens, int maxAge, HttpServletRequest request, HttpServletResponse response) {
		logger.debug("setCookie - begin");
		String[] newTokens = Arrays.copyOf(tokens, tokens.length + 1);
		newTokens[newTokens.length - 1] = getUserIpAddress(request);
		super.setCookie(newTokens, maxAge, request, response);
		logger.debug("setCookie - end");
	}

	@Override
	protected UserDetails processAutoLoginCookie(String[] cookieTokens, HttpServletRequest request, HttpServletResponse response) {
		logger.debug("processAutoLoginCookie - begin");
		try{
			setContext(request);
			String cookieIpAddress = cookieTokens[cookieTokens.length - 1];
			String requestIpAddress = getUserIpAddress(request);
			
			if(!cookieIpAddress.equals(requestIpAddress)){
				throw new InvalidCookieException("Cookie IP address did not contain a matching IP, contained: "+ cookieIpAddress);
			}
		}finally{
			setContext(null);
		}
		logger.debug("processAutoLoginCookie - end");
		return super.processAutoLoginCookie(Arrays.copyOf(cookieTokens, cookieTokens.length -1), request, response);
	}

	private String getUserIpAddress(HttpServletRequest request) {
		return request.getRemoteAddr();
	}
}
