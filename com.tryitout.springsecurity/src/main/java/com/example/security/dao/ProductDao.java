package com.example.security.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.security.data.Category;
import com.example.security.data.Item;

@Repository
public class ProductDao implements IProductDao {

	/** Category, IsForCustomerOnly */
	private Collection<Category> categories = new ArrayList<Category>();
	private Map<String,Collection<Item>> categoryItemsMap = new HashMap<String, Collection<Item>>();

	public ProductDao() {
		super();

		categories.add(new Category("Pet Apparel", false));
		categories.add(new Category("Dog Food", false));
		categories.add(new Category("Dog Supplies", false));
		categories.add(new Category("Dog Treats", false));
		categories.add(new Category("Cat Litter", false));
		categories.add(new Category("Cat Toys", false));
		categories.add(new Category("Training", false));
		categories.add(new Category("Travel", false));
		categories.add(new Category("Customer Appreciation Specials", true));
		
		categoryItemsMap.put("Pet Apparel", Arrays.asList(
						new Item("Collar"),
						new Item("Hibab")));
		
		categoryItemsMap.put("Dog Food",  Arrays.asList(
				new Item("Pedigree Adult"),
				new Item("Pedigree Puppy")));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.example.security.dao.IProductDao#getCategories()
	 */
	public Collection<Category> getCategories() {
		ArrayList<Category> ret = new ArrayList<Category>();
		ret.addAll(categories);
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.example.security.dao.IProductDao#getCategoryByName(java.lang.String)
	 */
	public Category getCategoryByName(String name) {
		for (Category c : categories) {
			if (name.equals(c.getName())) {
				return c;
			}
		}
		return null;
	}

	@Override
	public Collection<Category> filterCategories(Collection<Category> categories) {
		return categories;
	}

	@Override
	public Collection<Item> getItemsByCategory(String categoryName) {
		return categoryItemsMap.get(categoryName);
	}

	@Override
	public Category getCategoryById(int id) {
		for (Category category : categories) {
			if(category.getId() == id){
				return category;
			}
		}
		return null;
	}

}
