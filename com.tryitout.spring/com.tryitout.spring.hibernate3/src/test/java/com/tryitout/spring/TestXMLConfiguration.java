package com.tryitout.spring;

import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class TestXMLConfiguration {

	@Test
	public void test() {
		Configuration config = new Configuration();
		config.configure("/conf/hibernate.cfg.xml");

	}

}
