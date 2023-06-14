

import java.io.IOException;

import board.BBSDDL;
import board.BBSDTO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Count extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		BBSDTO bbs = new BBSDTO();
		BBSDDL ddl = new BBSDDL();
		String url = null;
		
		int num = Integer.parseInt(req.getParameter("num"));
		int count = Integer.parseInt(req.getParameter("count"));
		
		ddl.count(num, count);
			
		url = "content.jsp?num=" + num;
		res.sendRedirect(url);
		
	}

}
