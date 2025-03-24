package com.gcu.carstoreapplication.service;

import com.gcu.carstoreapplication.model.ProductModel;

import java.util.List;

public interface ProductServiceInterface {
    public List<ProductModel> getProducts();

    ProductModel getProductById(int id);

    public boolean updateProduct(ProductModel product);

    public boolean addProduct(ProductModel productModel);
}
