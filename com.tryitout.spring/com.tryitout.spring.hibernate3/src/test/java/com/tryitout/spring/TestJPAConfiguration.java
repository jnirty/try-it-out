package com.tryitout.spring;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;

import com.example.domain.Phone;
import com.example.domain.Student;

public class TestJPAConfiguration {

	@Test
	public void test() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hsqldbPersistenceUnit");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		// Creates a new object and persists it
		Student student = new Student("Richard", "Wright", "123", new Date(), "121221", new Date());
		student.setPhone(new Phone("0048754895667"));
		tx.begin();
		em.persist(student);
		tx.commit();

		Student persistedStudent = em.find(Student.class, student.getId());
		System.out.println("persisted: " + persistedStudent);
		
		em.close();
		emf.close();
		System.out.println("DONE");
	}

}
