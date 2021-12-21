package com.laptrinhjavawed.controller.wed;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavawed.imp.service.IProductService;
import com.laptrinhjavawed.model.Product;

/**
 * Servlet implementation class Shop
 */
@WebServlet(urlPatterns = { "/shop" })
public class Shop extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	IProductService product;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Shop() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String getAllPro = request.getParameter("getAllPro");
		String cateID = request.getParameter("code");
		List<Product> list = null;
		if (getAllPro != null && getAllPro.equals("getAll")) {
			list = product.getAll();
		} else {
			list = product.getAllByCateID(cateID);
		}
		request.setAttribute("list", list);
		List<Product> listGetTwo = product.getOneOrMoreSpecialDeals(2, cateID);
		request.setAttribute("listTwo", listGetTwo);
		request.getRequestDispatcher("/views/shop.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String search = request.getParameter("Search");
		List<Product> listSearch = product.getAllBySearch(search);
		request.setAttribute("listTwo", listSearch);
		request.setAttribute("list", listSearch);
		request.getRequestDispatcher("/views/shop.jsp").forward(request, response);
	}

}
