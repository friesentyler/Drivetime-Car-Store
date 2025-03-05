package com.gcu.carstoreapplication.productmodule;

import com.gcu.carstoreapplication.data.ProductDataService;
import com.gcu.carstoreapplication.data.ProductStore;
import com.gcu.carstoreapplication.model.ProductModel;
import com.gcu.carstoreapplication.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
	
    @Autowired
    private ProductService products;
	
    @GetMapping
    public String display(Model model) {
        List<ProductModel> productList = products.getProducts();
        model.addAttribute("title", "Product List");
        model.addAttribute("products", productList);
        return "products/displayproducts";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("title", "Create Product");
        model.addAttribute("productModel", new ProductModel());
        return "products/createproduct";
    }

    @PostMapping("/create")
    public String createProduct(@Valid @ModelAttribute("productModel") ProductModel productModel, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "Create Product");
            return "products/createproduct";
        }
        products.addProduct(productModel);
        return "redirect:/product";
    }

}
