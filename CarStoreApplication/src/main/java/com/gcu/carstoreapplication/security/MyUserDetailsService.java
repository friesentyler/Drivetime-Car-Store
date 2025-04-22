package com.gcu.carstoreapplication.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gcu.carstoreapplication.model.UserModel;
import com.gcu.carstoreapplication.service.UserService;

/**
 * Custom implementation of the {@link UserDetailsService} interface for loading user details by username.
 * It retrieves user information from the {@link UserService} and constructs a {@link UserDetails} object.
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserService userService;

    /**
     * Constructs a new {@link MyUserDetailsService} with the provided {@link UserService}.
     *
     * @param userService the {@link UserService} used to retrieve user data
     */
    @Autowired
    public MyUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    /**
     * Loads a {@link UserDetails} object based on the provided username.
     * If no user is found with the specified username, a {@link UsernameNotFoundException} is thrown.
     *
     * @param username the username of the user to load
     * @return a {@link UserDetails} object containing the user's information
     * @throws UsernameNotFoundException if no user is found with the given username
     */
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
