package com.gcu.carstoreapplication.service;

import com.gcu.carstoreapplication.data.ProductDataService;
import com.gcu.carstoreapplication.model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public ProductModel getProductById(int id)
    {
        return service.findById(id);
    }

    public boolean addProduct(ProductModel product) {
        if (service.create(product)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean updateProduct(ProductModel product) {
        if (service.update(product)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteProduct(int id) {
        ProductModel product = new ProductModel(id, "", "", 0.0f);
        return service.delete(product);
    }

    public void init() {
        System.out.println("init ordersbusinessservice");
    }

    public void destroy() {
        System.out.println("destroy ordersbusinessservice");
    }
}

