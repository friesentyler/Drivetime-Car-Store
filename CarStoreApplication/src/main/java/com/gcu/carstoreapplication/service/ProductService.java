package com.gcu.carstoreapplication.service;

import com.gcu.carstoreapplication.data.ProductDataService;
import com.gcu.carstoreapplication.model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class ProductService implements ProductServiceInterface {
    @Autowired
    ProductDataService service;

    @Override
    public List<ProductModel> getProducts() {
        List<ProductModel> products = service.findAll();
        List<ProductModel> updatedProducts = new ArrayList<>();

        for (ProductModel product : products) {
            updatedProducts.add(new ProductModel(product.getId(), product.getMake(), product.getModel(), product.getPrice()));
        }

        return updatedProducts;
    }

    public boolean addProduct(ProductModel product) {
        if (service.create(product)) {
            return true;
        } else {
            return false;
        }
    }

    public void init() {
        System.out.println("init ordersbusinessservice");
    }
    public void destroy() {
        System.out.println("destroy ordersbusinessservice");
    }
}

