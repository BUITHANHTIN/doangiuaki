package com.laptrinhjavawed.controller.wed;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavawed.imp.service.ICardService;
import com.laptrinhjavawed.imp.service.IProductService;
import com.laptrinhjavawed.model.Account;
import com.laptrinhjavawed.model.Card;
import com.laptrinhjavawed.model.Product;

import Utils.SessionUtils;

@WebServlet(urlPatterns = { "/trangchu" })
public class Trangchu extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	@Inject
	IProductService product;
	@Inject
	ICardService card;

	public Trangchu() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// id computer=0
		int idOfCompute = 0;
		if ((Account) SessionUtils.getInstance().getValue(request, "USERMODEL") != null) {
			SessionUtils.getInstance().removeValue(request, "giohangs");
			Account oneAccount = (Account) SessionUtils.getInstance().getValue(request, "USERMODEL");
			List<Card> listCard = card.getAllbyAccountId(oneAccount.getId());
			if (!listCard.isEmpty()) {
				SessionUtils.getInstance().putValue(request, "giohangs", listCard);
				List<Card> listSize = (List<Card>) SessionUtils.getInstance().getValue(request, "giohangs");
				request.setAttribute("listSize", listSize.size());
			}
			List<Product> list = product.getAllCateID();
			request.setAttribute("list", list);
			request.getRequestDispatcher("/views/index.jsp").forward(request, response);
		} else {
			List<Product> list = product.getAllCateID();
			request.setAttribute("list", list);
			List<Card> listCard = card.getAllbyAccountId(idOfCompute);
			if (!listCard.isEmpty()) {
				SessionUtils.getInstance().putValue(request, "giohangs", listCard);
				List<Card> listSize = (List<Card>) SessionUtils.getInstance().getValue(request, "giohangs");
				request.setAttribute("listSize", listSize.size());
			}

			request.getRequestDispatcher("/views/index.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
