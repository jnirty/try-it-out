package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController extends BaseController{

	@RequestMapping(method=RequestMethod.GET,value="/login.htm")
	public void login(Model model, @RequestParam(required=false, value="error") String error) {
		String msg = "";
		if(error!= null){
			msg = "Your session has expired because another session has started for this user.";
			model.addAttribute("error",msg);
		}
	}

}
