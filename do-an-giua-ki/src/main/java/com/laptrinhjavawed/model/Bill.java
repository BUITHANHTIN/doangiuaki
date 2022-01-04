package com.laptrinhjavawed.model;

public class Bill {
	int idAccount;
	String userName;
	String phone;
	String sumPrice;
	int sumCount;
	String address;
	String note;
	public Bill(int idAccount, String userName, String phone, String sumPrice, int sumCount, String address,
			String note) {
		super();
		this.idAccount = idAccount;
		this.userName = userName;
		this.phone = phone;
		this.sumPrice = sumPrice;
		this.sumCount = sumCount;
		this.address = address;
		this.note = note;
	}
	public int getIdAccount() {
		return idAccount;
	}
	public void setIdAccount(int idAccount) {
		this.idAccount = idAccount;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSumPrice() {
		return sumPrice;
	}
	public void setSumPrice(String sumPrice) {
		this.sumPrice = sumPrice;
	}
	public int getSumCount() {
		return sumCount;
	}
	public void setSumCount(int sumCount) {
		this.sumCount = sumCount;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	
}
