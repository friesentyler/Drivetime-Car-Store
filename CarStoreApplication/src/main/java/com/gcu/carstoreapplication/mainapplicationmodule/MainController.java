package com.gcu.carstoreapplication.mainapplicationmodule;

import com.gcu.carstoreapplication.loginmodule.LoginModel;
import jakarta.annotation.Resource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String home() {
        return "mainapplication/home";
    }
}
