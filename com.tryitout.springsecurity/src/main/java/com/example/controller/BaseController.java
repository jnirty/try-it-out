package com.example.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * This controller sets model attributes visible in all controllers extending
 * from it used to perform authentication checks in JSP forms.
 * 
 */
@Controller
public class BaseController {

	protected Authentication getAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}

	@ModelAttribute("showLoginLink")
	public boolean getShowLoginLink() {
		System.out.println("getShowLoginLink - begin");
		for (GrantedAuthority authority : getAuthentication().getAuthorities()) {
			System.out.println("getShowLoginLink - authority: " + authority.getAuthority());
			if (authority.getAuthority().equals("ROLE_USER")) {
				return false;
			}
		}
		return true;
	}

	@ModelAttribute("showLogoutLink")
	public boolean getShowLogoutLink() {
		return isLoggedInUser();
	}

	@ModelAttribute("showMyAccountLink")
	public boolean getShowMyAccountLink() {
		return isLoggedInUser();
	}

	private boolean isLoggedInUser() {
		System.out.println("isLoggedInUser - begin");
		boolean isLoggedIn = false;
		for (GrantedAuthority authority : getAuthentication().getAuthorities()) {
			System.out.println("isLoggedInUser - authority: " + authority.getAuthority());
			if (authority.getAuthority().equals("ROLE_USER")) {
				 isLoggedIn = true;
				 break;
			}
		}
		System.out.println("isLoggedInUser - end, return: " + isLoggedIn);
		return isLoggedIn;
	}
}
