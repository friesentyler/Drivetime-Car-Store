package com.gcu.carstoreapplication.loginmodule;

import com.gcu.carstoreapplication.data.UserStore;
import com.gcu.carstoreapplication.loginmodule.LoginModel;
import com.gcu.carstoreapplication.model.UserModel;

import com.gcu.carstoreapplication.service.UserService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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

/**
 * Controller responsible for handling login functionality, including rendering the login form
 * and processing login attempts.
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    /**
     * Service for user-related operations.
     */
    @Autowired
    private UserService userService;

    /**
     * Displays the login form.
     *
     * @param model the Spring {@link Model} used to pass attributes to the view
     * @return the path to the login form view
     */
    @GetMapping
    public String display(Model model) {
        model.addAttribute("title", "Login Form");
        model.addAttribute("loginModel", new LoginModel());
        return "/login/login";
    }

    /**
     * Processes the login form submission and checks for valid credentials.
     *
     * @param loginModel the {@link LoginModel} object containing the submitted login data
     * @param bindingResult the result of validating the login form
     * @param model the Spring {@link Model} used to pass attributes to the view
     * @return the path to either a success or failure view based on login results
     */
    @PostMapping("/doLogin")
    public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "Login Form");
            return "/login/login";
        }

        UserModel account = userService.getUserByUsername(loginModel.getUsername());

        if (account == null || !account.getPassword().equals(loginModel.getPassword())) {
            return "login/failure"; // Invalid login
        }

        model.addAttribute("title", "Success");
        return "login/success";
    }
}
