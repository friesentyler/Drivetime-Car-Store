package com.gcu.carstoreapplication.service;

        import com.gcu.carstoreapplication.data.UserDataService;
        import com.gcu.carstoreapplication.data.UserStore;
        import com.gcu.carstoreapplication.model.UserModel;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.List;

/**
 * Service class for handling user-related operations.
 * This class provides methods to retrieve users, add new users, and fetch a user by their username.
 */
@Service
public class UserService implements UserServiceInterface {

    @Autowired
    private UserDataService service;

    // THE SERVICE USES THE USER STORE STILL
    // IN THE NEXT MILESTONE, WE WILL SWITCH TO THE DATABASE INSTEAD
    @Autowired
    private UserStore userStore;

    /**
     * Retrieves all users from the data service.
     *
     * @return a list of {@link UserModel} representing all users
     */
    @Override
    public List<UserModel> getAllUsers() {
        return service.findAll();
    }

    /**
     * Retrieves a user by their username.
     *
     * @param username the username of the user to retrieve
     * @return the {@link UserModel} of the user with the specified username
     */
    @Override
    public UserModel getUserByUsername(String username) {
        return service.getByUserName(username);
    }

    /**
     * Adds a new user to the system.
     *
     * @param user the {@link UserModel} containing the details of the user to add
     * @return true if the user was successfully added, false otherwise
     */
    @Override
    public boolean addUser(UserModel user) {
        return service.create(user);
    }
}