package com.example.security.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.security.dao.IProductDao;
import com.example.security.data.Category;
import com.example.security.data.Item;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private IProductDao productDao;
	
	@Override
	public Collection<Category> getCategories() {
		Collection<Category> unfilteredCategories = productDao.getCategories();
		Collection<Category> filteredCategories = productDao.filterCategories(unfilteredCategories);
		return filteredCategories;
	}

	@Override
	public Category getCategoryByName(String name) {
		return productDao.getCategoryByName(name);
	}

	@Override
	public Collection<Item> getItemsByCategory(String categoryName) {
		return productDao.getItemsByCategory(categoryName);
	}

	@Override
	public Category getCategoryById(int id) {
		return productDao.getCategoryById(id);
	}

}
