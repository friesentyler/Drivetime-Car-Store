package com.gcu.carstoreapplication.productmodule;

import com.gcu.carstoreapplication.data.ProductDataService;
import com.gcu.carstoreapplication.data.ProductStore;
import com.gcu.carstoreapplication.model.ProductModel;
import com.gcu.carstoreapplication.service.ProductService;
import com.gcu.carstoreapplication.service.ProductServiceInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for managing product-related actions.
 * Handles the display, creation, updating, and deletion of products.
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductServiceInterface products;

    /**
     * Displays a list of all products.
     *
     * @param model the model object used to pass attributes to the view
     * @return the name of the view to render
     */
    @GetMapping
    public String display(Model model) {
        List<ProductModel> productList = products.getProducts();
        model.addAttribute("title", "Product List");
        model.addAttribute("products", productList);
        return "products/displayproducts";
    }

    /**
     * Displays the form to create a new product.
     *
     * @param model the model object used to pass attributes to the view
     * @return the name of the view to render
     */
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("title", "Create Product");
        model.addAttribute("productModel", new ProductModel());
        return "products/createproduct";
    }

    /**
     * Handles the submission of the form to create a new product.
     * Validates the product data and, if valid, adds the product to the list.
     *
     * @param productModel the product to be created
     * @param bindingResult contains the result of the validation process
     * @param model the model object used to pass attributes to the view
     * @return the name of the view to render, or a redirect if the product is created successfully
     */
    @PostMapping("/create")
    public String createProduct(@Valid @ModelAttribute("productModel") ProductModel productModel, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "Create Product");
            return "products/createproduct";
        }
        products.addProduct(productModel);
        return "redirect:/product";
    }

    /**
     * Displays the form to update an existing product.
     *
     * @param id the ID of the product to update
     * @param model the model object used to pass attributes to the view
     * @return the name of the view to render, or a redirect if the product is not found
     */
    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        ProductModel product = products.getProductById(id);
        if (product == null) {
            return "redirect:/product?error=productNotFound";
        }
        model.addAttribute("title", "Update Product");
        model.addAttribute("productModel", product);
        return "products/updateproduct";
    }

    /**
     * Handles the submission of the form to update an existing product.
     * Validates the product data and, if valid, updates the product in the list.
     *
     * @param productModel the product to be updated
     * @param bindingResult contains the result of the validation process
     * @param model the model object used to pass attributes to the view
     * @return the name of the view to render, or a redirect if the product is updated successfully
     */
    @PostMapping("/update")
    public String updateProduct(@Valid @ModelAttribute("productModel") ProductModel productModel, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "Update Product");
            return "products/updateproduct";
        }
        products.updateProduct(productModel);
        return "redirect:/product";
    }

    /**
     * Handles the deletion of an existing product.
     *
     * @param id the ID of the product to delete
     * @return the name of the view to render, redirecting to the product list
     */
    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        products.deleteProduct(id);
        return "redirect:/product";
    }
}
