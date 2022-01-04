package com.laptrinhjavawed.service;

import javax.inject.Inject;

import com.laptrinhjavawed.DAO.IAccount;
import com.laptrinhjavawed.imp.service.IAccountService;
import com.laptrinhjavawed.model.Account;

public class AccountService implements IAccountService {
	@Inject
	private IAccount account;

	@Override
	public Account getOneAccount(String user, String pass) {
		return account.getOneAccount(user, pass).isEmpty() ? null : account.getOneAccount(user, pass).get(0);
	}

	@Override
	public String UsernameExist(String username) {
		return account.UsernameExist(username);
	}

	@Override
	public boolean InsertAccount(Account account1) {
		if (account.InsertAccount(account1)) {
			return true;
		} else {
			return false;
		}
	}
}
