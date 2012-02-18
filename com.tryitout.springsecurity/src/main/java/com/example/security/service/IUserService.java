package com.example.security.service;

import javax.annotation.security.RolesAllowed;

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
	@RolesAllowed({"ROLE_USER","ROLE_ADMIN"})
	public void changePassword(String username, String password);
}
