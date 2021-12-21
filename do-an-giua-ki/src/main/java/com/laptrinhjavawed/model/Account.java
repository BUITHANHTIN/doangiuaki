package com.laptrinhjavawed.model;

import java.util.ArrayList;

public class Account {
	int id;
	String user, pass;
	int isSell, isAdmin;
	ArrayList<Product> listProduct;

	public ArrayList<Product> getListProduct() {
		return listProduct;
	}

	public void setListProduct(ArrayList<Product> listProduct) {
		this.listProduct = listProduct;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getIsSell() {
		return isSell;
	}

	public void setIsSell(int isSell) {
		this.isSell = isSell;
	}

	public int getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

	public Account() {
		super();
	}

	public Account(int id, String user, String pass, int isSell, int isAdmin) {
		super();
		this.id = id;
		this.user = user;
		this.pass = pass;
		this.isSell = isSell;
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", user=" + user + ", pass=" + pass + ", isSell=" + isSell + ", isAdmin=" + isAdmin
				+ "]";
	}

}
