package com.example.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.service.ReaderService;

@Controller
public class HomeController {

	@Autowired
	private ReaderService readerService;
	
	@RequestMapping("/home.htm")
	public String home(Model model) {
		model.addAttribute("today", new Date());
		model.addAttribute("readerData", readerService.fetchData());
		
		return "home";	
	}
	@RequestMapping("/")
	public String homeRoot(Model model) {
		model.addAttribute("today", new Date());
		return "home";	
	}

}
