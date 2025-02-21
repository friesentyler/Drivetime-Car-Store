package com.gcu.carstoreapplication.data;

import com.gcu.carstoreapplication.model.ProductModel;
import com.gcu.carstoreapplication.model.UserModel;

import java.util.ArrayList;

public class ProductStore {

	private static ArrayList<ProductModel> products = new ArrayList<ProductModel>();
	private static int idIncrement = 1;

	public ProductStore() {

	}
	
	public void addProduct(ProductModel product) {
		if (product.getId() == 0) {
			product.setId(idIncrement);
			idIncrement++;
		}
		products.add(product);
	}
	
	public void clearProducts() {
		products.clear();
		idIncrement=1;
	}
	
	public ArrayList<ProductModel> getAll() {
		
		return products;
	}
}
