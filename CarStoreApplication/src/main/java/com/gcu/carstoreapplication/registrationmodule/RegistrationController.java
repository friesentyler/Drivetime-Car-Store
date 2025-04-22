package com.gcu.carstoreapplication.registrationmodule;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.carstoreapplication.data.UserStore;
import com.gcu.carstoreapplication.model.UserModel;
import com.gcu.carstoreapplication.service.UserService;

import jakarta.validation.Valid;

/**
 * Controller responsible for handling registration-related endpoints.
 * Provides functionality for displaying the registration form and processing the registration of a new user.
 */
@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private UserService userService;

    /**
     * Displays the registration form for a new user.
     *
     * @param model the model to hold attributes for the view
     * @return the view name for the registration form
     */
    @GetMapping
    public String display(Model model) {
        // Display Login Form View
        model.addAttribute("title", "Login Form");
        model.addAttribute("userModel", new UserModel());
        return "/registration/registration";
    }

    /**
     * Handles the registration of a new user.
     * Validates the registration form, and if no errors, attempts to add the user.
     *
     * @param userModel the user data from the registration form
     * @param bindingResult the result of binding form data to the UserModel
     * @param model the model to hold attributes for the view
     * @return the view name to display after attempting registration (either the list of users or an error page)
     */
    @PostMapping("/register")
    public String doLogin(@Valid UserModel userModel, BindingResult bindingResult, Model model) {

        // Check for validation errors
        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "Registration Form");
            return "/registration/registration";
        }

        boolean success = userService.addUser(userModel);

        if (success) {
            List<UserModel> userList = userService.getAllUsers();

            model.addAttribute("title", "My Orders");
            model.addAttribute("users", userList);

            return "registration/allusers";
        }
        else {
            return "registration/duplicate";
        }
    }
}