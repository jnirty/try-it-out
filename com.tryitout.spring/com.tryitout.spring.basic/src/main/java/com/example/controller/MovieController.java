package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.example.persistence.IMovieDAO;

@Controller
public class MovieController {

	@Autowired
	private IMovieDAO movieDao;

	@RequestMapping("/movies/list.htm")
	public String list(Model model) {
		model.addAttribute("movies", movieDao.getAllMovies());
		return "movies/list";
	}
	@RequestMapping("/movies/create.htm")
	public String home(Model model) {
		return "movies/create";
	}
	@RequestMapping("/movies")
	public ModelAndView movieRoot() {
		return  new ModelAndView(new RedirectView("movies/list.htm"));
	}

}
