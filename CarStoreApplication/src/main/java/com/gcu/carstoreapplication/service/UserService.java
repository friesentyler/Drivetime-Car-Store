package com.gcu.carstoreapplication.service;

import com.gcu.carstoreapplication.data.UserStore;
import com.gcu.carstoreapplication.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserServiceInterface {
	
	// THE SERVICE USES THE USER STORE STILL
	// IN THE NEXT MILESTONE, WE WILL SWITCH TO THE DATABASE INSTEAD
    @Autowired
    private UserStore userStore;
    
    @Override
    public List<UserModel> getAllUsers() {
        return userStore.getAll();
    }
    
    @Override
    public UserModel getUserByUsername(String username) {
        return userStore.getAll().stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }
    
    @Override
    public void addUser(UserModel user) {
        userStore.addUser(user);
    }

}
