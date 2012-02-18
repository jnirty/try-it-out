package com.example.security.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.security.dao.IProductDao;
import com.example.security.data.Category;

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

}
