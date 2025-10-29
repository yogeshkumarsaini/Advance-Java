package servlet_session_tracking.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet (value="/login")
public class LoginUserController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession httpSession = req.getSession();

		String userName = req.getParameter("userName");
		String password = req.getParameter("userPassword");

		if ((userName.equals("root")) && (password.equals("123"))) {
			httpSession.setAttribute("username", userName);
		//	httpSession.setMaxInactiveInterval(5);
			req.getRequestDispatcher("user-home.jsp").forward(req, resp);
		} else {
			req.setAttribute("msg", "login username or password is incorrect");
			req.getRequestDispatcher("login.jsp").forward(req, resp);

		}
	}
}