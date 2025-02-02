package com.gcu.carstoreapplication.data;

import java.util.ArrayList;

import com.gcu.carstoreapplication.model.UserModel;

public class UserStore {
	
	private static ArrayList<UserModel> users = new ArrayList<UserModel>();

	public UserStore() {

	}
	
	public void addUser(UserModel user) {
		users.add(user);
	}
	
	public void clearUsers() {
		users.clear();
	}
	
	public ArrayList<UserModel> getAll() {
		
		return users;
	}
}
