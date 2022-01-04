package com.laptrinhjavawed.service;

import java.util.List;

import javax.inject.Inject;

import com.laptrinhjavawed.DAO.IProduct;
import com.laptrinhjavawed.imp.service.IProductService;
import com.laptrinhjavawed.model.Product;

public class ProductService implements IProductService {
	@Inject
	private IProduct product;

	@Override
	public List<Product> getAllCateID() {
		return product.getAllCateID();
	}

	@Override
	public List<Product> getAllByCateID(String cateID) {
		return product.getAllByCateID(cateID);
	}

	@Override
	public List<Product> getOneOrMoreSpecialDeals(int top,String cateID) {
		return product.getOneOrMoreSpecialDeals(top, cateID);
	}

	@Override
	public List<Product> getAllBySearch(String searchTitle) {
		return product.getAllBySearch(searchTitle);
	}

	@Override
	public Product getOneById(String id) {
		return product.getOneById(id);
	}

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return product.getAll();
	}

	@Override
	public int countgetAllProduct() {
		return product.countgetAllProduct();
	}

	@Override
	public int countgetAllProduct(String cateID) {
		return product.countgetAllProduct(cateID);
	}

	@Override
	public List<Product> getProducByPaging(int input, int param) {
		return product.getProducByPaging(input, param);
	}
	
}
