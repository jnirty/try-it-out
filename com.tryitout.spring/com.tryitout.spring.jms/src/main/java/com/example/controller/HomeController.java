package com.example.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/home.htm")
	public String home(Model model) {
		model.addAttribute("today", new Date());
		
		return "home";	
	}
	@RequestMapping("/")
	public String homeRoot(Model model) {
		model.addAttribute("today", new Date());
		return "home";	
	}

}
