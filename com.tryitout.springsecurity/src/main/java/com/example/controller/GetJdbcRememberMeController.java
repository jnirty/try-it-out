package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.security.DatabaseQueryBean;

@Controller
public class GetJdbcRememberMeController extends BaseController{

	@Autowired
	@Qualifier("databaseQueryBean")
	private DatabaseQueryBean databaseQueryBean;
	
	@RequestMapping("/GetJdbcRememberMe.htm")
	public String getJdbcRememberMe(Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = principal.toString();
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		}
		System.out.println("/GetJdbcRememberMe.htm, username = " + username);
		String result = databaseQueryBean.query(username);
		model.addAttribute("rememberMe", result);
		return "GetJdbcRememberMe";	
	}

}
