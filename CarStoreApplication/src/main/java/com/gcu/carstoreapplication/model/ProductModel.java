package com.gcu.carstoreapplication.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Model class representing a product in the car store.
 * This class contains properties related to the product, such as its ID, make, model, and price.
 */
public class ProductModel {

    /**
     * Default constructor for ProductModel.
     */
    public ProductModel() {

    }

    /**
     * Constructor for ProductModel with all required fields.
     *
     * @param id the ID of the product
     * @param make the make (brand) of the product
     * @param model the model of the product
     * @param price the price of the product
     */
    public ProductModel(int id, String make, String model, float price) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.price = price;
    }

    // Define the properties
    private int id;

    /**
     * The make (brand) of the product.
     * This field cannot be null and must be between 1 and 32 characters.
     */
    @NotNull(message = "Make must have a name")
    @Size(min = 1, max = 32, message = "Make name must be between 1 and 32 characters")
    private String make;

    /**
     * The model of the product.
     * This field cannot be null and must be between 1 and 32 characters.
     */
    @NotNull(message = "Model must have a name")
    @Size(min = 1, max = 32, message = "Model name must be between 1 and 32 characters")
    private String model;

    /**
     * The price of the product.
     * This field cannot be null.
     */
    @NotNull(message = "Price is a required field")
    private float price;

    /**
     * Gets the ID of the product.
     *
     * @return the ID of the product
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the product.
     *
     * @param id the ID to set for the product
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the make (brand) of the product.
     *
     * @return the make of the product
     */
    public String getMake() {
        return make;
    }

    /**
     * Sets the make (brand) of the product.
     *
     * @param make the make to set for the product
     */
    public void setMake(String make) {
        this.make = make;
    }

    /**
     * Gets the model of the product.
     *
     * @return the model of the product
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets the model of the product.
     *
     * @param model the model to set for the product
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Gets the price of the product.
     *
     * @return the price of the product
     */
    public float getPrice() {
        return price;
    }

    /**
     * Sets the price of the product.
     *
     * @param price the price to set for the product
     */
    public void setPrice(float price) {
        this.price = price;
    }
}
