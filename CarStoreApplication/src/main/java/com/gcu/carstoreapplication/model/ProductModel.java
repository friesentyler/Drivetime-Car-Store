package com.gcu.carstoreapplication.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ProductModel {
    // define the properties
    private int id;

    @NotNull(message = "Make must have a name")
    @Size(min = 1, max = 32, message = "Make name must be between 1 and 32 characters")
    private String make;

    // category name defined with error checking
    @NotNull(message = "Model must have a name")
    @Size(min = 1, max = 32, message = "Model name must be between 1 and 32 characters")
    private String model;

    // price defined with error checking
    @NotNull(message = "price is a required field")
    private float price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
