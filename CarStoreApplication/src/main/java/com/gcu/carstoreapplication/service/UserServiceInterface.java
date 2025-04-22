package com.gcu.carstoreapplication.service;

import java.util.List;

import com.gcu.carstoreapplication.model.UserModel;

/**
 * Interface for user-related service operations.
 * This interface defines methods for retrieving all users, retrieving a user by their username,
 * and adding a new user.
 */
public interface UserServiceInterface {

	/**
	 * Retrieves all users from the system.
	 *
	 * @return a list of {@link UserModel} representing all users
	 */
	public List<UserModel> getAllUsers();

	/**
	 * Retrieves a user by their username.
	 *
	 * @param userName the username of the user to retrieve
	 * @return the {@link UserModel} representing the user with the specified username
	 */
	public UserModel getUserByUsername(String userName);

	/**
	 * Adds a new user to the system.
	 *
	 * @param user the {@link UserModel} containing the details of the user to add
	 * @return true if the user was successfully added, false otherwise
	 */
	public boolean addUser(UserModel user);
}
