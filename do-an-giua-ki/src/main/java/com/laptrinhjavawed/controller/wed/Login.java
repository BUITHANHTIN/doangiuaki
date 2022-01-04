package com.laptrinhjavawed.controller.wed;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavawed.imp.service.IAccountService;
import com.laptrinhjavawed.imp.service.ICardService;
import com.laptrinhjavawed.model.Account;

import Utils.SessionUtils;

@WebServlet(urlPatterns = { "/j_security_check" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	IAccountService account;
	@Inject
	ICardService card;
	ResourceBundle resource = ResourceBundle.getBundle("message");

	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// code bên form login
		String code = request.getParameter("code");
		if (code != null && code.equals("login")) {
			String mess = request.getParameter("message");
			String messageRegistration = request.getParameter("messageRe");
			if (mess != null) {
				request.setAttribute("message", resource.getString(mess));
			}
			if (messageRegistration != null) {
				request.setAttribute("messageRe", resource.getString(messageRegistration));
			}
			// lay Cooki day len form login
			Cookie[] arr = request.getCookies();
			if (arr != null) {
				for (Cookie cookie : arr) {
					if (cookie.getName().equals("usernameCookie")) {
						request.setAttribute("username", cookie.getValue());
					}
					if (cookie.getName().equals("passwordCookie")) {
						request.setAttribute("password", cookie.getValue());
					}
				}
			}
			request.getRequestDispatcher("/views/login.jsp").forward(request, response);
		} else if (code != null && code.equals("thoat")) {
			SessionUtils.getInstance().removeValue(request, "USERMODEL");
			SessionUtils.getInstance().removeValue(request, "giohangs");
			response.sendRedirect(request.getContextPath() + "/trangchu");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		String user = request.getParameter("j_username");
		String pass = request.getParameter("j_password");
		String name = request.getParameter("name");
		if (action != null && action.equals("login")) {
			Account oneAccount = account.getOneAccount(user, pass);
			if (oneAccount != null) {
				SessionUtils.getInstance().putValue(request, "USERMODEL", oneAccount);
				// luu Cooki
				Cookie username = new Cookie("usernameCookie", user);
				Cookie password = new Cookie("passwordCookie", pass);
				username.setMaxAge(60 * 60 * 24 * 365);
				password.setMaxAge(60 * 60 * 24 * 365);
				response.addCookie(username);
				response.addCookie(password);

				if (oneAccount.getIsAdmin() == 1) {
					response.sendRedirect(request.getContextPath() + "/admin-home");
				} else if (oneAccount.getIsAdmin() == 0) {
					response.sendRedirect(request.getContextPath() + "/trangchu");
				}
				// kiem tra trong user co du lieu gio hang ch

			} else if (oneAccount == null) {
				response.sendRedirect(request.getContextPath() + "/j_security_check?code=login&message=message");
			}
		} else if (action != null && action.equals("registration")) {
			// kiểm tra có tên trong account ch
			if (account.UsernameExist(name) != null) {
				response.sendRedirect(
						request.getContextPath() + "/j_security_check?code=login&messageRe=messageRegistration");
			} else {
				Account acc = new Account();
				acc.setUsername(name);
				acc.setUser(user);
				acc.setPass(pass);
				// insert và gửi mail thành công
				boolean checkInsert = account.InsertAccount(acc);
				if (checkInsert) {
					final String fromEmail = "maingocdcm01091997@gmail.com";
					// Mat khai email cua ban
					final String password = "bangtansonyeondan";
					// dia chi email nguoi nhan
					final String toEmail = user;
					final String subject = "Web bán hàng";
					final String body = "Đăng kí thành công";
					Properties props = new Properties();
					props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP Host
					props.put("mail.smtp.port", "587"); // TLS Port
					props.put("mail.smtp.auth", "true"); // enable authentication
					props.put("mail.smtp.starttls.enable", "true"); // enable STARTTLS
					Authenticator auth = new Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(fromEmail, password);
						}
					};
					Session session = Session.getInstance(props, auth);
					MimeMessage msg = new MimeMessage(session);
					// set message headers
					try {
						msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
						msg.addHeader("format", "flowed");
						msg.addHeader("Content-Transfer-Encoding", "8bit");
						msg.setFrom(new InternetAddress(fromEmail, "NoReply-JD"));
						msg.setReplyTo(InternetAddress.parse(fromEmail, false));
						msg.setSubject(subject, "UTF-8");
						msg.setText(body, "UTF-8");
						msg.setSentDate(new Date());
						msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
						Transport.send(msg);
					} catch (MessagingException e) {
						// TODO: handle exception
					}
					System.out.println("Gui mail thanh cong");

					response.sendRedirect(request.getContextPath() + "/j_security_check	?code=login");
				} else {

				}
			}
		}

	}

}
