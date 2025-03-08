package com.gcu.carstoreapplication.service;

import com.gcu.carstoreapplication.data.UserDataService;
import com.gcu.carstoreapplication.data.UserStore;
import com.gcu.carstoreapplication.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserServiceInterface {
	
	@Autowired
	private UserDataService service;
	
	// THE SERVICE USES THE USER STORE STILL
	// IN THE NEXT MILESTONE, WE WILL SWITCH TO THE DATABASE INSTEAD
    @Autowired
    private UserStore userStore;
    
    @Override
    public List<UserModel> getAllUsers() {
        return service.findAll();
    }
    
    @Override
    public UserModel getUserByUsername(String username) {
        return service.getByUserName(username);
    }
    
    @Override
    public boolean addUser(UserModel user) {
        return service.create(user);
    }

}
