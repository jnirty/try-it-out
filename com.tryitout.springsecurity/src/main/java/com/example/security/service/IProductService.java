package com.example.security.service;

import java.util.Collection;

import org.springframework.security.access.prepost.PostFilter;

import com.example.security.data.Category;

public interface IProductService {

	/**
	 * Get all categories the user has access to.
	 * 
	 * @return the list of available categories
	 */
	Collection<Category> getCategories();

	/**
	 * Finds the category with the given name.
	 * @param name the name of the category to find.
	 * @return the matching category, or null
	 */
	Category getCategoryByName(String name);
}
