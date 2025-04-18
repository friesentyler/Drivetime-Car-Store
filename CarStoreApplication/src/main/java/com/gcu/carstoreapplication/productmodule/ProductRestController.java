package com.gcu.carstoreapplication.productmodule;

import com.gcu.carstoreapplication.data.ProductDataService;
import com.gcu.carstoreapplication.model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductRestController {

    @Autowired
    private ProductDataService productService;

    // Get all products
    @GetMapping("/products")
    public List<ProductModel> getAllProducts() {
        return productService.findAll();
    }

    // Get a product by ID
    @GetMapping("products/{id}")
    public ProductModel getProductById(@PathVariable int id) {
        return productService.findById(id);
    }
}