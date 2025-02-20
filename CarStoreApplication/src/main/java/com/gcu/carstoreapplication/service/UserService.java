package com.gcu.carstoreapplication.service;

import com.gcu.carstoreapplication.data.UserStore;
import com.gcu.carstoreapplication.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserStore userStore;

    public List<UserModel> getAllUsers() {
        return userStore.getAll();
    }
    public UserModel getUserByUsername(String username) {
        return userStore.getAll().stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }
    public void addUser(UserModel user) {
        userStore.addUser(user);
    }

}
