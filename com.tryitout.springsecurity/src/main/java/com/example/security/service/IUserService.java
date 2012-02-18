package com.example.security.service;


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
	public void changePassword(String username, String password);
}