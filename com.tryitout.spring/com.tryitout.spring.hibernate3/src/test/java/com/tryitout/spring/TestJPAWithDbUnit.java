package com.tryitout.spring;

import static org.junit.Assert.assertEquals;

import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.tryitout.spring.util.DataHelper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/ioc/backend/applicationContextTest2.xml" })
@Transactional
@TransactionConfiguration(transactionManager = "testTxManager")
public class TestJPAWithDbUnit {

	@Autowired
	private SessionFactory testSessionFactory;

	@Before
	public void setUp() throws Exception {
		new DataHelper(testSessionFactory).loadDatabaseData(new String[]{"student"});
	}

	@Test
	public void test1() throws Exception {
		System.out.println("test1() - begin");
		Long count = (Long) testSessionFactory.getCurrentSession().createQuery("select count(*) from Student").list().get(0);
		assertEquals(Long.valueOf(1l), count);
		System.out.println("test1() - end");
	}

	@Test
	public void test2() throws Exception {
		System.out.println("test2() - begin");
		Long count = (Long) testSessionFactory.getCurrentSession().createQuery("select count(*) from Student").list().get(0);
		assertEquals(Long.valueOf(1l), count);
		System.out.println("test2() - end");
	}

}
