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

//import com.gcu.model.LoginModel;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
	
	@Autowired
	private UserService userService;

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
        
        userService.addUser(userModel);
        
        List<UserModel> userList = userService.getAllUsers();

        model.addAttribute("title", "My Orders");
        model.addAttribute("users", userList);
        
        return "registration/allusers";
    }
}
