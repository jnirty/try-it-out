package com.example.security.dao;

import java.util.Collection;

import org.springframework.security.access.prepost.PreFilter;

import com.example.security.data.Category;

public interface IProductDao {
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
	 * Filters categories depending on user access
	 * @param unfilteredCategoties all categories from database
	 * @return categories user has access to
	 */
	@PreFilter("(!filterObject.customersOnly) or (filterObject.customersOnly and hasRole('ROLE_USER') )")
	Collection<Category> filterCategories(Collection<Category> unfilteredCategoties);
}
