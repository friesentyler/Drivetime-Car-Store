package com.gcu.carstoreapplication.registrationmodule;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.carstoreapplication.data.UserStore;
import com.gcu.carstoreapplication.model.UserModel;

import jakarta.validation.Valid;

//import com.gcu.model.LoginModel;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
	
	private static UserStore users = new UserStore();

    @GetMapping
    public String display(Model model) {
        // Display Login Form View
        model.addAttribute("title", "Login Form");
        model.addAttribute("userModel", new UserModel());
        return "/registration/registration";
    }
    
    @PostMapping("/register")
    public String doLogin(@Valid UserModel userModel, BindingResult bindingResult, Model model) {
        // Check for validation errors
        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "Registration Form");
            return "/registration/registration";
        }
        
        users.addUser(userModel);
        
        System.out.println(userModel.getFirstName());
        model.addAttribute("title", "My Orders");
        model.addAttribute("users", users.getAll());
        
        // THIS NEEDS TO BE CHANGED TO REDIRECT TO THE LOGIN PAGE INSTEAD
        return "registration/allUsers";
    }
}
