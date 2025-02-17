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

}
