package com.laptrinhjavawed.imp.service;

import com.laptrinhjavawed.model.Account;

public interface IAccountService {
	Account getOneAccount(String user, String pass);

	String UsernameExist(String username);

	boolean InsertAccount(Account account);
}
