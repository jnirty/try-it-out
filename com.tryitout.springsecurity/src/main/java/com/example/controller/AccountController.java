package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.security.IChangePassword;
import com.example.security.service.IUserService;

@Controller
public class AccountController extends BaseController {

	@Autowired
	IUserService userService;

	@RequestMapping(value = "/account/home.htm")
	public void home() {
	}

	@RequestMapping(value = "/account/changePassword.htm", method = RequestMethod.POST)
	public String changePassword(@RequestParam("newPassword") String password) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = principal.toString();
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		}
		userService.changePassword(username, password);
		SecurityContextHolder.clearContext();
		return "redirect:home.htm";
	}

	@RequestMapping(value = "/account/changePassword.htm", method = RequestMethod.GET)
	public void showPassword() {

	}
}
