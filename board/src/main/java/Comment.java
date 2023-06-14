

import java.io.IOException;

import board.BBSDDL;
import board.BBSDTO;
import board.CommentDDL;
import board.CommentDTO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Comment extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.getWriter().append("Served at: ").append(req.getContextPath());
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		BBSDTO bdto = new BBSDTO();
		BBSDDL bddl = new BBSDDL();
		CommentDTO cdto = new CommentDTO();
		CommentDDL cddl = new CommentDDL();
		String url = null;
		int reply = Integer.parseInt(req.getParameter("reply"));
		int num = Integer.parseInt(req.getParameter("num"));
		
		cdto.setUsername(req.getParameter("userid"));
		cdto.setUserpass(req.getParameter("userpass"));
		cdto.setComment(req.getParameter("comment"));
		cdto.setUip();
		cdto.setBbsnum(num);
		
		bdto.setNum(num);

		
		boolean isSuccess = cddl.insert(cdto);
		bddl.reply(num, reply);
		if(isSuccess) {
			System.out.println("insert is success");
			
			url = "content.jsp?num=" + num;
			res.sendRedirect(url);
		}else {
			System.out.println("insert is failed");
			
			url = "content.jsp?num=" + num;
			res.sendRedirect(url);
		}
		
		doGet(req, res);
	}

}
