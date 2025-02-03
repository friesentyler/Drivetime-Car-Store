package com.gcu.carstoreapplication.loginmodule;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class LoginModel {
        @NotNull(message="User name is a required field.")
        @Size(min=1, max=32, message="User name must be between 1 and 32 characters.")
        private String username;
        @NotNull(message="Password is a required field.")
        @Size(min=1, max=32, message="Password must be between 1 and 32 characters.")
        private String password;

        // Getters and Setters
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
