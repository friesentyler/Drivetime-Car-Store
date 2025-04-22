
package com.gcu.carstoreapplication.mainapplicationmodule;

import com.gcu.carstoreapplication.loginmodule.LoginModel;
import jakarta.annotation.Resource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller class for handling requests to the main application.
 * Currently, it handles the home page of the application.
 */
@Controller
public class MainController {

    /**
     * Handles GET requests to the root URL ("/").
     * Returns the view name for the home page of the application.
     *
     * @return the name of the home page view
     */
    @GetMapping("/")
    public String home() {
        return "mainapplication/home";
    }
}
