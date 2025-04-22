package com.gcu.carstoreapplication.productmodule;

import com.gcu.carstoreapplication.data.ProductDataService;
import com.gcu.carstoreapplication.model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST controller for handling product-related API endpoints.
 * Provides methods for retrieving all products and a specific product by its ID.
 */
@RestController
@RequestMapping("/api")
public class ProductRestController {

    @Autowired
    private ProductDataService productService;

    /**
     * Retrieves a list of all products.
     *
     * @return a list of all product models
     */
    @GetMapping("/products")
    public List<ProductModel> getAllProducts() {
        return productService.findAll();
    }

    /**
     * Retrieves a product by its ID.
     *
     * @param id the ID of the product to retrieve
     * @return the product model corresponding to the given ID
     */
    @GetMapping("products/{id}")
    public ProductModel getProductById(@PathVariable int id) {
        return productService.findById(id);
    }
}