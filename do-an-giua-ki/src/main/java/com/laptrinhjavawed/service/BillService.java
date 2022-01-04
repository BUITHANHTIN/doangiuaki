package com.laptrinhjavawed.service;

import javax.inject.Inject;

import com.laptrinhjavawed.DAO.IBill;
import com.laptrinhjavawed.imp.service.IBillService;
import com.laptrinhjavawed.model.Bill;

public class BillService implements IBillService {
	@Inject
	private IBill bill;

	@Override
	public int insertBill(Bill billUser) {

		return bill.insertBill(billUser);

	}

}
