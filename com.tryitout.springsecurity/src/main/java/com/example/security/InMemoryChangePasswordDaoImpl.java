package com.example.security;

import org.apache.log4j.Logger;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.memory.InMemoryDaoImpl;

@SuppressWarnings("deprecation")
public class InMemoryChangePasswordDaoImpl extends InMemoryDaoImpl implements IChangePassword {

	private Logger logger = Logger.getLogger(InMemoryChangePasswordDaoImpl.class);
	@Override
	public void changePassword(String username, String password) {
		logger.debug("changePassword - begin, username = " + username);
		User user = (User) getUserMap().getUser(username);
		User newUser = new User(username, password, user.isEnabled(), user.isAccountNonExpired(), user.isCredentialsNonExpired(), user.isAccountNonLocked(), user.getAuthorities());
		getUserMap().addUser(newUser);
		logger.debug("changePassword - end");
	}

}
