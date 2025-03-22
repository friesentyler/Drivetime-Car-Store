package com.gcu.carstoreapplication.service;

import com.gcu.carstoreapplication.model.ProductModel;

import java.util.List;

public interface ProductServiceInterface {
    public List<ProductModel> getProducts();

    public boolean addProduct(ProductModel productModel);

    public boolean deleteProduct(int id);

}
