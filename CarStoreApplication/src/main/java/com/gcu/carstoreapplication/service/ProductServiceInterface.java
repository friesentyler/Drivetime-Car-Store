package com.gcu.carstoreapplication.service;

import com.gcu.carstoreapplication.model.ProductModel;

import java.util.List;

/**
 * Interface for product-related services.
 * Provides methods for retrieving, adding, updating, and deleting products.
 */
public interface ProductServiceInterface {

    /**
     * Retrieves a list of all products.
     *
     * @return a list of {@link ProductModel} representing all products
     */
    public List<ProductModel> getProducts();

    /**
     * Retrieves a product by its ID.
     *
     * @param id the ID of the product to retrieve
     * @return the {@link ProductModel} of the product with the specified ID
     */
    ProductModel getProductById(int id);

    /**
     * Updates the details of an existing product.
     *
     * @param product the {@link ProductModel} containing the updated product details
     * @return true if the product was successfully updated, false otherwise
     */
    public boolean updateProduct(ProductModel product);

    /**
     * Adds a new product to the system.
     *
     * @param productModel the {@link ProductModel} containing the details of the new product
     * @return true if the product was successfully added, false otherwise
     */
    public boolean addProduct(ProductModel productModel);

    /**
     * Deletes a product by its ID.
     *
     * @param id the ID of the product to delete
     * @return true if the product was successfully deleted, false otherwise
     */
    public boolean deleteProduct(int id);
}
