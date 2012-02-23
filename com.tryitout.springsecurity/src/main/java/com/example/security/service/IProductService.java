package com.example.security.service;

import java.util.Collection;

import org.springframework.security.access.annotation.Secured;

import com.example.security.data.Category;
import com.example.security.data.Item;

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
	/**
	 * Finds the category with the given id.
	 * @param name the id of the category to find.
	 * @return the matching category, or null
	 */
	Category getCategoryById(int id);
	
	Collection<Item> getItemsByCategory(Category cat);
}
