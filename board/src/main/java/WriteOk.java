

import java.io.IOException;

import board.BBSDDL;
import board.BBSDTO;
import board.MembersDTO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class WriteOk extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		MembersDTO mdto = new MembersDTO();
		BBSDTO dto = new BBSDTO();
		BBSDDL ddl = new BBSDDL();
		String url = null;
		
		mdto.setUserid(req.getParameter("userid"));
		mdto.setUserpass(req.getParameter("userpass"));
		mdto.setUsername(req.getParameter("username"));
		mdto.setUseremail(req.getParameter("useremail"));
		mdto.setUip();
		dto.setTitle(req.getParameter("title"));
		dto.setContent(req.getParameter("content"));
		
		boolean isSuccess = ddl.insert(mdto, dto);
		
		if(isSuccess) {
			System.out.println("insert is success");
			
			url = "free.jsp";
			res.sendRedirect(url);
		}else {
			System.out.println("insert is failed");
			url = "write.jsp";
			res.sendRedirect(url);
		}
		
		doGet(req, res);
	}

}
