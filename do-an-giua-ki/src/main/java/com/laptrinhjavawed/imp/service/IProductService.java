package com.laptrinhjavawed.imp.service;

import java.util.List;

import com.laptrinhjavawed.model.Product;

public interface IProductService {
	List<Product> getAllCateID();

	List<Product> getAllByCateID(String cateID);

	List<Product> getOneOrMoreSpecialDeals(int top, String cateID);

	List<Product> getAllBySearch(String searchTitle);

	Product getOneById(String id);

	List<Product> getAll();
}
