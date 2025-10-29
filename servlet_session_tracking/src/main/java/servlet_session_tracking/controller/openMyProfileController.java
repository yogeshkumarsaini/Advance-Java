package servlet_session_tracking.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet (value="/myprofile")
public class openMyProfileController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession httpSession = req.getSession();
		
		if(httpSession.getAttribute("username")!=null) {
			
			req.getRequestDispatcher("myprofile.jsp").forward(req, resp);
		}
		else {
			req.setAttribute("msg", "your session is out please login again");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
		

	}

}
