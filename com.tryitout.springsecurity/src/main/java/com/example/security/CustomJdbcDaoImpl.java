package com.example.security;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

/**
 * This class extends Spring class to add password change functionality, but
 * sprint already provides a class that gives CRUD operations on users, which
 * is: org.springframework.security.privisioning.JdbcUserDetailsManager - this could be used instead.
 * 
 */
public class CustomJdbcDaoImpl extends JdbcDaoImpl implements IChangePassword {

	private Logger logger = Logger.getLogger(CustomJdbcDaoImpl.class);

	@Override
	public void changePassword(String username, String password) {
		logger.debug("changePassword - begin - updating user password for user: " + username);

		JdbcTemplate template = getJdbcTemplate();
		template.update("UPDATE USERS SET PASSWORD =  ? WHERE USERNAME = ?", password, username);

		logger.debug("changePassword - end");
	}

	/**
	 * Override superclass method for test purpose only to see that actually
	 * this service is running
	 */
	@Override
	protected List<GrantedAuthority> loadUserAuthorities(String username) {
		System.out.println("...loadUserAuthorities...");
		return super.loadUserAuthorities(username);
	}
}
