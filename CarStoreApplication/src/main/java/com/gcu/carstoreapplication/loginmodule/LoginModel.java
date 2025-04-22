
package com.gcu.carstoreapplication.loginmodule;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Model class representing the login form data.
 * It contains the user's credentials (username and password) with validation constraints.
 */
public class LoginModel {

    /**
     * The username for the login.
     * This field is required and must be between 1 and 32 characters.
     */
    @NotNull(message="User name is a required field.")
    @Size(min=1, max=32, message="User name must be between 1 and 32 characters.")
    private String username;

    /**
     * The password for the login.
     * This field is required and must be between 1 and 32 characters.
     */
    @NotNull(message="Password is a required field.")
    @Size(min=1, max=32, message="Password must be between 1 and 32 characters.")
    private String password;

    /**
     * Gets the username for login.
     *
     * @return the username for login
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username for login.
     *
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password for login.
     *
     * @return the password for login
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password for login.
     *
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
