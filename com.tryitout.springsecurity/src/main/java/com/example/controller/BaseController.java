package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class BaseController {

	
	@Autowired
	SessionRegistry sessionRegistry;
	
	@ModelAttribute("numUsers")
	public int getNumberOfUsers(){
		return sessionRegistry.getAllPrincipals().size();
	}
}
