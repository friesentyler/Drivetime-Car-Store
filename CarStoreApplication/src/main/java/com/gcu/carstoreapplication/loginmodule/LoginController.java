package com.gcu.carstoreapplication.loginmodule;

import com.gcu.carstoreapplication.loginmodule.LoginModel;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/login")
public class LoginController {
    @GetMapping
    public String display(Model model) {
        model.addAttribute("title", "Login Form");
        model.addAttribute("loginModel", new LoginModel());
        return "/login/login";
    }
    @PostMapping("/doLogin")
    public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model) {

        if(bindingResult.hasErrors())
        {
            System.out.println("here");
            model.addAttribute("title", "Login Form");
            return "/login/login";
        }

        System.out.println(String.format("Form submitted with Username: %s and Password: %s",
                loginModel.getUsername(), loginModel.getPassword()));
        return "login/products";
    }
}
