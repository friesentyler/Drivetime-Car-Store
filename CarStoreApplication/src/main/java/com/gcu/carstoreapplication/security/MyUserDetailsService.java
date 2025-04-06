package com.gcu.carstoreapplication.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gcu.carstoreapplication.model.UserModel;
import com.gcu.carstoreapplication.service.UserService;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public MyUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user = userService.getUserByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        return User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles("USER") // Or get roles from the database
                .build();
    }
}