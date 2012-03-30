package com.tryitout.spring;

import static org.junit.Assert.assertEquals;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.domain.Student;

public class TestJPAWithDbUnit extends AbstractTest<Student, String> {

	@Autowired
	private SessionFactory testSessionFactory;

	@Override
	public String[] entities() {
		return new String[] { "student" };
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
