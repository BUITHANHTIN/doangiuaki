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

@WebServlet(urlPatterns = { "/single" })
public class Single extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	IProductService product;

	public Single() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String codeID = request.getParameter("code");
		String cateID=request.getParameter("cateID");
		Product oneProduct = product.getOneById(codeID);
		List<Product> listGetFour = product.getOneOrMoreSpecialDeals(4, cateID);
		request.setAttribute("listFour", listGetFour);
		request.setAttribute("oneprod", oneProduct);
		request.getRequestDispatcher("/views/single.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}