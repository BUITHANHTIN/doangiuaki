package com.laptrinhjavawed.controller.wed;

import java.io.IOException;
import java.util.ArrayList;

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
@WebServlet(urlPatterns = { "/checkout" })
public class CheckOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	IProductService product;

	public CheckOut() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Product> list = new ArrayList<>();
		String id = request.getParameter("id");
		String shoe_item = request.getParameter("shoe_item");
		String image = request.getParameter("image");
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String cateID = request.getParameter("cateID");
		String sellID = request.getParameter("sellID");
		String amount = request.getParameter("amount");
//		Product product = new Product(Integer.parseInt(id), shoe_item, image, Double.parseDouble(amount), title,
//				description, Integer.parseInt(cateID), Integer.parseInt(sellID));
		Product product=new Product();
	//	product.setId(Integer.parseInt(id));
		product.setName(shoe_item);
		product.setImage(image);
	//	product.setPrice( Double.parseDouble(amount));
		product.setTitle(title);
		list.add(product);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/views/checkout.jsp").forward(request, response);
	}

}
