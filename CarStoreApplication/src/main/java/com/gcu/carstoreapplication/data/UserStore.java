package com.gcu.carstoreapplication.data;

import java.util.ArrayList;

import com.gcu.carstoreapplication.model.UserModel;

public class UserStore {
	
	private static ArrayList<UserModel> users = new ArrayList<UserModel>();
	private static int idIncrement = 1;

	public UserStore() {

	}
	
	public void addUser(UserModel user) {
		if (user.getId() == 0) {
			user.setId(idIncrement);
			idIncrement++;
		}
		users.add(user);
	}
	
	public void clearUsers() {
		users.clear();
		idIncrement=1;
	}
	
	public ArrayList<UserModel> getAll() {
		
		return users;
	}
}
