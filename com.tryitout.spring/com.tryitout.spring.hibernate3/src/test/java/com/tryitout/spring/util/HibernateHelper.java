package com.tryitout.spring.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateHelper {
	private static final ThreadLocal<Session> session = new ThreadLocal<Session>();
	private static final ThreadLocal transaction = new ThreadLocal();
	private static final SessionFactory sessionFactory = new Configuration().configure("/conf/hibernate.cfg.xml").buildSessionFactory();

	// inaccessible constructor
	private HibernateHelper() {
	}

	public static Session getSession() {
		Session session = (Session) HibernateHelper.session.get();
		if (session == null) {
			session = sessionFactory.openSession();
			HibernateHelper.session.set(session);
		}
		return session;
	}
}
