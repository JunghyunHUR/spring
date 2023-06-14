

import java.io.IOException;

import board.MemberDDL;
import board.MembersDTO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberLevelUpdate extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.getWriter().append("Served at: ").append(req.getContextPath());
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		MembersDTO dto = new MembersDTO();
		MemberDDL ddl = new MemberDDL();
		String url = null;
		String user = req.getParameter("userid");
		
		dto.setLevel(Integer.parseInt(req.getParameter("level")));

		boolean isSuccess = ddl.update(dto, user);
		doGet(req, res);
	}

}
