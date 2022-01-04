package com.laptrinhjavawed.DAO;

import java.util.List;

import com.laptrinhjavawed.model.Account;

public interface IAccount {
	List<Account> getOneAccount(String user, String pass);

	String UsernameExist(String username);

	boolean InsertAccount(Account account);
}
