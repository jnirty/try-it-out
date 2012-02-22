package com.example.controller;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.security.data.Category;
import com.example.security.data.Item;
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

	@RequestMapping(method=RequestMethod.GET,value="/viewCategory.htm")
	public void viewCategory(@RequestParam("id") String categoryId, ModelMap model) {
		Category cat = productService.getCategoryById(Integer.parseInt(categoryId));
		System.out.println("category = " + cat);
		model.addAttribute("category", cat);
		Collection<Item> items = productService.getItemsByCategory(cat);
		System.out.println("items = " + items);
		model.addAttribute("items", items);
	}
}
