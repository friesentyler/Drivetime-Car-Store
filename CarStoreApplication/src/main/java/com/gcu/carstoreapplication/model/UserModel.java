package com.gcu.carstoreapplication.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;

public class UserModel {
    // define the properties
    private int id;

    // username defined with error checking
    @NotNull(message = "Username is a required field")
    @Size(min = 1, max = 32, message = "User name must be between 1 and 32 characters")
    private String username;

    // first name defined with error checking
    @NotNull(message = "First name is a required field")
    @Size(min = 1, max = 32, message = "First name must be between 1 and 32 characters")
    private String firstName;

    // last name defined with error checking
    @NotNull(message = "Last name is a required field")
    @Size(min = 1, max = 32, message = "Last name must be between 1 and 32 characters")
    private String lastName;

    // password defined with error checking
    @NotNull(message = "Password is a required field")
    @Size(min = 1, max = 32, message = "Password must be between 1 and 32 characters")
    private String password;

    // email defined with error checking
    @NotNull(message = "Email name is a required field")
    @Size(min = 1, max = 32, message = "Email must be between 1 and 32 characters")
    @Email(message = "Email must be a valid format")
    private String email;

    // phone defined with error checking
    @NotNull(message = "Phone is a required field")
    @Size(min = 1, max = 32, message = "Phone name must be between 1 and 32 characters")
    private String phone;

    // default constructor
    public UserModel() {
        this.id = 0;
        this.username = "";
        this.firstName = "";
        this.lastName = "";
        this.password = "";
        this.email = "";
        this.phone = "";
    }

    // parameterized constructor
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

    // getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
