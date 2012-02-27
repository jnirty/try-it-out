package com.tryitout.spring;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Phone;
import com.example.domain.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/ioc/backend/applicationContextTest2.xml" })
@Transactional
@TransactionConfiguration(transactionManager = "testTxManager")
public class TestJPAWithSpring2 {

	@Autowired
	private SessionFactory testSessionFactory;
	private Session session = null;

	@Before
	public void setUp() throws Exception {
		Student student = new Student("John", "Smith", "342", new Date(), "2312312", new Date());
		student.setPhone(new Phone("0048456567900"));
		session = testSessionFactory.openSession();
		session.persist(student);

		// print the created entity
		Student persistedStudent = (Student)session.get(Student.class, student.getId());
		System.out.println("student = " + persistedStudent);
	}

	@Test
	public void test1() throws Exception {
		System.out.println("test1() - begin");
		Long count = (Long) session.createQuery("select count(*) from Student").list().get(0);
		assertEquals(Long.valueOf(1l), count);
		System.out.println("test1() - end");
	}

	@Test
	public void test2() throws Exception {
		System.out.println("test2() - begin");
		Long count = (Long) session.createQuery("select count(*) from Student").list().get(0);
		assertEquals(Long.valueOf(1l), count);
		System.out.println("test2() - end");
	}

}
