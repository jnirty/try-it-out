package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccountController {

	@Autowired
	@Qualifier("jdbcUserService")
	private UserDetailsManager userDetailsManager;

	@RequestMapping(value = "/account/home.htm")
	public void home() {
	}

	@RequestMapping(value = "/account/changePassword.htm", method = RequestMethod.POST)
	public String changePassword(@RequestParam("oldPassword") String oldPassword,@RequestParam("newPassword") String newPassword) {
		userDetailsManager.changePassword(oldPassword, newPassword);
		SecurityContextHolder.clearContext();
		return "redirect:home.htm";
	}

	@RequestMapping(value = "/account/changePassword.htm", method = RequestMethod.GET)
	public void showPassword() {

	}
}
