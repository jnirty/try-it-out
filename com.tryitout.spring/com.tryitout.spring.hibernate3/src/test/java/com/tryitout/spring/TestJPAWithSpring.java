package com.tryitout.spring;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Phone;
import com.example.domain.Student;

/**
 * This tests JPA configuration with EntityManager, each method is automatically
 * rolled back after execution in @Transactional context
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/ioc/backend/applicationContextTest.xml" })
@Transactional
public class TestJPAWithSpring {

	@PersistenceContext
	EntityManager em;

	@Before
	public void setUp() throws Exception {
		Student student = new Student("John", "Smith", "342", new Date(), "2312312", new Date());
		student.setPhone(new Phone("0048456567900"));
		em.persist(student);

		// print the created entity
		Student persistedStudent = em.find(Student.class, student.getId());
		System.out.println("student = " + persistedStudent);
	}

	@Test
	public void test1() throws Exception {
		System.out.println("test1() - begin");
		Long count = (Long) em.createQuery("select count(*) from Student").getSingleResult();
		assertEquals(Long.valueOf(1l), count);
		System.out.println("test1() - end");
	}

	@Test
	public void test2() throws Exception {
		System.out.println("test2() - begin");
		Long count = (Long) em.createQuery("select count(*) from Student").getSingleResult();
		assertEquals(Long.valueOf(1l), count);
		System.out.println("test2() - end");
	}

}