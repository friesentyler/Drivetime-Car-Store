package com.gcu.carstoreapplication.data;

		import java.util.ArrayList;

		import com.gcu.carstoreapplication.model.UserModel;
		import org.springframework.stereotype.Repository;

/**
 * In-memory repository class for storing and managing {@link UserModel} objects.
 * This class simulates persistent storage using a static list.
 */
@Repository
public class UserStore {

	private static ArrayList<UserModel> users = new ArrayList<UserModel>();
	private static int idIncrement = 1;

	/**
	 * Default constructor for {@link UserStore}.
	 */
	public UserStore() {

	}

	/**
	 * Adds a user to the store. If the user has an ID of 0, an auto-incremented ID is assigned.
	 *
	 * @param user the {@link UserModel} to add
	 */
	public void addUser(UserModel user) {
		if (user.getId() == 0) {
			user.setId(idIncrement);
			idIncrement++;
		}
		users.add(user);
	}

	/**
	 * Clears all users from the store and resets the ID counter.
	 */
	public void clearUsers() {
		users.clear();
		idIncrement = 1;
	}

	/**
	 * Retrieves all users currently in the store.
	 *
	 * @return an {@link ArrayList} of {@link UserModel} objects
	 */
	public ArrayList<UserModel> getAll() {
		return users;
	}
}
