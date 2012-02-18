package com.example.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.security.service.IProductService;

@Controller
public class HomeController extends BaseController {

	@Autowired
	private IProductService productService;
	
	@RequestMapping("/home.htm")
	public String home(Model model) {
		model.addAttribute("categories", productService.getCategories());
		return "home";	
	}
	@RequestMapping("/")
	public String homeRoot(Model model) {
		model.addAttribute("today", new Date());
		return "home";	
	}

}
