package com.example.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.event.HomeNavigatedEvent;
import com.example.event.MyEventPublisher;
import com.example.persistence.DatabaseQueryBean;
import com.example.service.ReaderService;
import com.example.util.ShoppingBasket;

@Controller
public class HomeController {

	@Autowired
	private ReaderService readerService;
	
	@Autowired
	private ShoppingBasket shoppingBasket;
	
	@Autowired
	private MyEventPublisher eventPublisher;
	
	@Autowired
	private DatabaseQueryBean databaseQueryBean;
	
	@RequestMapping("/home.htm")
	public String home(Model model) {
		model.addAttribute("today", new Date());
		model.addAttribute("readerData", readerService.fetchData());
		model.addAttribute("shoppingBasketsNum",shoppingBasket.getId());
		
		eventPublisher.publishEvent(new HomeNavigatedEvent(this, "navigated /home.htm"));
		
		model.addAttribute("order",databaseQueryBean.query(1));
		model.addAttribute("orders",databaseQueryBean.findAll());
		return "home";	
	}
	@RequestMapping("/")
	public String homeRoot(Model model) {
		model.addAttribute("today", new Date());
		return "home";	
	}

}
