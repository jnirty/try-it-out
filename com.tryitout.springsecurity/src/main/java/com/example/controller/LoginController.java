package com.example.controller;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController extends BaseController {

	@RequestMapping(method = RequestMethod.GET, value = "/login.htm")
	public void login(Model model, @RequestParam(required = false, value = "error") String error) {
		String msg = "";
		if (error != null) {
			msg = "Your session has expired because another session has started for this user.";
			model.addAttribute("error", msg);
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/accessDenied.htm")
	public void accessDenied(ModelMap model, HttpServletRequest request) {
		AccessDeniedException exception = (AccessDeniedException) request.getAttribute(WebAttributes.ACCESS_DENIED_403);
		StringWriter sw = new StringWriter();
		exception.printStackTrace(new PrintWriter(sw));
		model.addAttribute("errorDetails", exception.getMessage());
		model.addAttribute("errorTrace", sw.toString());
	}

}
