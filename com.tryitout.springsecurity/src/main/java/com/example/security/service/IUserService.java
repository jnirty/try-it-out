package com.example.security.service;

import org.springframework.security.access.prepost.PreAuthorize;

public interface IUserService {
	/**
	 * Changes the password for the given username. Expects that the calling
	 * user is a valid user of the system.
	 * 
	 * @param username
	 *            the name of the user to change
	 * @param password
	 *            the password to change to
	 */
	@PreAuthorize("hasRole('ROLE_USER')")
	public void changePassword(String username, String password);
}
