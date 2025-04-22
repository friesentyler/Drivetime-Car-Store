package com.gcu.carstoreapplication.data;

import com.gcu.carstoreapplication.model.ProductModel;
import com.gcu.carstoreapplication.model.UserModel;

import java.util.ArrayList;

/**
 * A simple in-memory store for managing {@link ProductModel} instances.
 * Provides functionality to add, retrieve, and clear products.
 */
public class ProductStore {

	private static ArrayList<ProductModel> products = new ArrayList<ProductModel>();
	private static int idIncrement = 1;

	/**
	 * Default constructor for ProductStore.
	 */
	public ProductStore() {

	}

	/**
	 * Adds a product to the store. Automatically assigns an ID if one is not set.
	 *
	 * @param product the {@link ProductModel} to add
	 */
	public void addProduct(ProductModel product) {
		if (product.getId() == 0) {
			product.setId(idIncrement);
			idIncrement++;
		}
		products.add(product);
	}

	/**
	 * Clears all products from the store and resets the ID counter.
	 */
	public void clearProducts() {
		products.clear();
		idIncrement = 1;
	}

	/**
	 * Retrieves all products currently in the store.
	 *
	 * @return an {@link ArrayList} of {@link ProductModel} objects
	 */
	public ArrayList<ProductModel> getAll() {
		return products;
	}
}
