package com.laptrinhjavawed.controller.wed;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavawed.imp.service.IAccountService;
import com.laptrinhjavawed.imp.service.IProductService;
import com.laptrinhjavawed.model.Account;
import com.laptrinhjavawed.model.Product;

import Utils.SessionUtils;

@WebServlet(urlPatterns = { "/trangchu", "/login" })
public class Trangchu extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	IAccountService account;
	@Inject
	IProductService product;
	ResourceBundle resource = ResourceBundle.getBundle("message");

	public Trangchu() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String code = request.getParameter("code");
		if (code != null && code.equals("dangnhap")) {
			String mess = request.getParameter("message");
			if (mess != null) {
				request.setAttribute("message", resource.getString(mess));
			}
			request.getRequestDispatcher("/views/login/login.jsp").forward(request, response);
		} else if (code != null && code.equals("dangki")) {
			request.getRequestDispatcher("/views/login/registration.jsp").forward(request, response);
		} else if (code != null && code.equals("thoat")) {
			SessionUtils.getInstance().removeValue(request, "USERMODEL");
			response.sendRedirect(request.getContextPath() + "/trangchu");
		} else {
			List<Product> list=product.getAllCateID();
			request.setAttribute("list", list);
			request.getRequestDispatcher("/views/index.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action != null && action.equals("login")) {
			String user = request.getParameter("username");
			String pass = request.getParameter("password");
			Account oneAccount = account.getOneAccount(user, pass);
			if (oneAccount != null) {
				SessionUtils.getInstance().putValue(request, "USERMODEL", oneAccount);
				if (oneAccount.getIsAdmin() == 1) {
					response.sendRedirect(request.getContextPath() + "/admin-home");
				} else if (oneAccount.getIsAdmin() == 0) {
					response.sendRedirect(request.getContextPath() + "/trangchu");
				}
			} else if (oneAccount == null) {
				response.sendRedirect(request.getContextPath() + "/login?code=dangnhap&message=message");
			}
		} else {

		}
	}

}
