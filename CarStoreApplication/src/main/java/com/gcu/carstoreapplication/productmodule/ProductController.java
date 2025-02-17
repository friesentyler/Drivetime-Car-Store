package com.gcu.carstoreapplication.productmodule;

import com.gcu.carstoreapplication.data.UserStore;
import com.gcu.carstoreapplication.loginmodule.LoginModel;
import com.gcu.carstoreapplication.model.UserModel;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	private static UserStore users = new UserStore();
	
    @GetMapping
    public String display(Model model) {
        model.addAttribute("title", "Login Form");
        model.addAttribute("loginModel", new LoginModel());
        return "/login/login";
    }
    @PostMapping("/doLogin")
    public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            System.out.println("here");
            model.addAttribute("title", "Login Form");
            return "/login/login";
        }
        
        List<UserModel> userList = users.getAll();
        
        UserModel account = null;
        for (UserModel user : userList) {
            if (user.getUsername().equals(loginModel.getUsername())) {
                account = user;
                break;
            }
        }
        
        if (account == null || !account.getPassword().equals(loginModel.getPassword())) {
            return "login/failure"; // Invalid login
        }
        
        model.addAttribute("title", "Success");
        return "login/success"; 
    }

}
