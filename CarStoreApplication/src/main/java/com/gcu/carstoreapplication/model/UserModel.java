package com.gcu.carstoreapplication.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;

/**
 * Represents a user in the car store application.
 * This class holds user information such as their username, first name, last name, password,
 * email, and phone number with validation constraints.
 */
public class UserModel {
    // Define the properties
    private int id;

    /**
     * The username of the user.
     * This field cannot be null and must be between 1 and 32 characters.
     */
    @NotNull(message = "Username is a required field")
    @Size(min = 1, max = 32, message = "User name must be between 1 and 32 characters")
    private String username;

    /**
     * The first name of the user.
     * This field cannot be null and must be between 1 and 32 characters.
     */
    @NotNull(message = "First name is a required field")
    @Size(min = 1, max = 32, message = "First name must be between 1 and 32 characters")
    private String firstName;

    /**
     * The last name of the user.
     * This field cannot be null and must be between 1 and 32 characters.
     */
    @NotNull(message = "Last name is a required field")
    @Size(min = 1, max = 32, message = "Last name must be between 1 and 32 characters")
    private String lastName;

    /**
     * The password of the user.
     * This field cannot be null and must be between 1 and 32 characters.
     */
    @NotNull(message = "Password is a required field")
    @Size(min = 1, max = 32, message = "Password must be between 1 and 32 characters")
    private String password;

    /**
     * The email of the user.
     * This field cannot be null, must be between 1 and 32 characters, and must be a valid email format.
     */
    @NotNull(message = "Email name is a required field")
    @Size(min = 1, max = 32, message = "Email must be between 1 and 32 characters")
    @Email(message = "Email must be a valid format")
    private String email;

    /**
     * The phone number of the user.
     * This field cannot be null and must be between 1 and 32 characters.
     */
    @NotNull(message = "Phone is a required field")
    @Size(min = 1, max = 32, message = "Phone name must be between 1 and 32 characters")
    private String phone;

    /**
     * Default constructor for UserModel.
     * Initializes the properties with default values.
     */
    public UserModel() {
        this.id = 0;
        this.username = "";
        this.firstName = "";
        this.lastName = "";
        this.password = "";
        this.email = "";
        this.phone = "";
    }

    /**
     * Constructor for UserModel with all fields.
     *
     * @param id the ID of the user
     * @param username the username of the user
     * @param firstName the first name of the user
     * @param lastName the last name of the user
     * @param password the password of the user
     * @param email the email address of the user
     * @param phone the phone number of the user
     */
    public UserModel(int id, String username, String firstName, String lastName, String password, String email,
                     String phone) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    /**
     * Gets the ID of the user.
     *
     * @return the ID of the user
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the user.
     *
     * @param id the ID to set for the user
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the username of the user.
     *
     * @return the username of the user
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the user.
     *
     * @param username the username to set for the user
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the first name of the user.
     *
     * @return the first name of the user
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the user.
     *
     * @param firstName the first name to set for the user
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the user.
     *
     * @return the last name of the user
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the user.
     *
     * @param lastName the last name to set for the user
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the password of the user.
     *
     * @return the password of the user
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user.
     *
     * @param password the password to set for the user
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the email address of the user.
     *
     * @return the email address of the user
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the user.
     *
     * @param email the email to set for the user
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the phone number of the user.
     *
     * @return the phone number of the user
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the phone number of the user.
     *
     * @param phone the phone number to set for the user
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

}
