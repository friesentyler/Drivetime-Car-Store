package com.gcu.carstoreapplication.mainapplicationmodule;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String home() {
        return "mainapplication/home";
    }
}
