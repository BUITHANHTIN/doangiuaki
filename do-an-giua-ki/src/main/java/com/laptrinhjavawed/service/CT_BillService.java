package com.laptrinhjavawed.service;

import javax.inject.Inject;

import com.laptrinhjavawed.DAO.ICT_Bill;
import com.laptrinhjavawed.imp.service.ICT_BillService;
import com.laptrinhjavawed.model.CT_Bill;

public class CT_BillService implements ICT_BillService {
	@Inject
	private ICT_Bill ctBill;

	@Override
	public boolean insert_CT_Bill(CT_Bill Bill) {
		if (ctBill.insert_CT_Bill(Bill)) {
			return true;
		} else {
			return false;
		}
	}
}
