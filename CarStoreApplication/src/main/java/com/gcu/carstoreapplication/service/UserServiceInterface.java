package com.gcu.carstoreapplication.service;

import java.util.List;

import com.gcu.carstoreapplication.model.UserModel;

public interface UserServiceInterface {
	
	public List<UserModel> getAllUsers();
	
	public UserModel getUserByUsername(String userName);
	
	public boolean addUser(UserModel user);

}
