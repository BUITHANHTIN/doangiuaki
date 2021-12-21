package com.laptrinhjavawed.DAO;

import java.util.List;

import com.laptrinhjavawed.model.Account;
import com.laptrinhjavawed.model.Product;

public interface IProduct {
	 List<Product> getAllCateID() ;
	 List<Product> getAllByCateID(String cateID) ;
	 List<Product> getOneOrMoreSpecialDeals(int top,String cateID) ;
	 List<Product> getAllBySearch(String searchTitle) ;
	 Product getOneById(String id) ;
	 List<Product> getAll() ;
	 
	 
	 
}
