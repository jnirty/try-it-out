package com.example.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.security.IChangePassword;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IChangePassword changePasswordDao;

	@Override
	public void changePassword(String username, String password) {
		changePasswordDao.changePassword(username, password);
	}

}
