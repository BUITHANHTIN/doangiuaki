package com.laptrinhjavawed.DAO;

import java.util.List;

import com.laptrinhjavawed.model.Account;
import com.laptrinhjavawed.model.Product;

public interface IAccount {
	 List<Account> getOneAccount(String user, String pass) ;
	 
}
