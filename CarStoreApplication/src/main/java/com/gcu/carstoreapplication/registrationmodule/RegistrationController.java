package com.gcu.carstoreapplication.registrationmodule;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.carstoreapplication.model.UserModel;

//import com.gcu.model.LoginModel;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @GetMapping
    public String display(Model model) {
        // Display Login Form View
        model.addAttribute("title", "Login Form");
        model.addAttribute("userModel", new UserModel());
        return "/registration/registration";
    }
    /*
     * @PostMapping("/doLogin")
     * public String doLogin(UserModel loginModel, BindingResult bindingResult,
     * Model model) {
     * // Print the form values
     * System.out.println(String.format("Username: %s, Password: %s",
     * userModel.getFirstName(), userModel.getPassword()));
     * 
     * // Navigate back to the login view
     * return "registration-success";
     * }
     */
}
