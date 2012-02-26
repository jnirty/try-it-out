package com.tryitout.spring;

import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.example.domain.Book;

public class TestPropertiesConfiguration {

	@Test
	public void test() {
		Configuration config = new Configuration();
		config.addClass(Book.class);// only if .hbm.xml is in the same location as Book.class
	}

}
