package com.gcu.carstoreapplication.service;

import com.gcu.carstoreapplication.data.ProductDataService;
import com.gcu.carstoreapplication.model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service class for handling product-related operations such as fetching, adding, updating, and deleting products.
 * Implements the {@link ProductServiceInterface} interface.
 */
@Service
public class ProductService implements ProductServiceInterface {

    @Autowired
    ProductDataService service;

    /**
     * Retrieves a list of all products with only relevant fields (id, make, model, and price).
     *
     * @return a list of {@link ProductModel} containing the relevant details of all products
     */
    @Override
    public List<ProductModel> getProducts() {
        List<ProductModel> products = service.findAll();
        List<ProductModel> updatedProducts = new ArrayList<>();

        for (ProductModel product : products) {
            updatedProducts.add(new ProductModel(product.getId(), product.getMake(), product.getModel(), product.getPrice()));
        }

        return updatedProducts;
    }

    /**
     * Retrieves a product by its ID.
     *
     * @param id the ID of the product to retrieve
     * @return the {@link ProductModel} of the product with the specified ID
     */
    @Override
    public ProductModel getProductById(int id) {
        return service.findById(id);
    }

    /**
     * Adds a new product to the system.
     *
     * @param product the {@link ProductModel} containing the details of the product to add
     * @return true if the product was successfully added, false otherwise
     */
    public boolean addProduct(ProductModel product) {
        if (service.create(product)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Updates an existing product in the system.
     *
     * @param product the {@link ProductModel} containing the updated details of the product
     * @return true if the product was successfully updated, false otherwise
     */
    public boolean updateProduct(ProductModel product) {
        if (service.update(product)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Deletes a product by its ID.
     *
     * @param id the ID of the product to delete
     * @return true if the product was successfully deleted, false otherwise
     */
    @Override
    public boolean deleteProduct(int id) {
        ProductModel product = new ProductModel(id, "", "", 0.0f);
        return service.delete(product);
    }

    /**
     * Initialization method for the product service.
     * Prints a message when the service is initialized.
     */
    public void init() {
        System.out.println("init ordersbusinessservice");
    }

    /**
     * Destruction method for the product service.
     * Prints a message when the service is destroyed.
     */
    public void destroy() {
        System.out.println("destroy ordersbusinessservice");
    }
}
