package net.jason.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet({ "/", "/login" })
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			req.getRequestDispatcher("login.jsp").forward(req, res);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			String userid = req.getParameter("userid");
			String userpass = req.getParameter("userpass");
			
			String adminid = "admin";
			String adminpass = "1234";
			
			if(adminid.equals(userid) && adminpass.equals(userpass)) {
				HttpSession session = req.getSession();
				session.setAttribute("isLogged", true);
				session.setAttribute("userid", userid);
				res.sendRedirect("welcome.jsp");
			}else {
				res.sendRedirect("login?error=true");
			}
	}

}
