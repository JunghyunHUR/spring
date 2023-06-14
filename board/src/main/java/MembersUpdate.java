

import java.io.IOException;
import java.io.PrintWriter;

import board.MemberDDL;
import board.MembersDTO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MembersUpdate extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		MembersDTO dto = new MembersDTO();
		MemberDDL ddl = new MemberDDL();
		String url = null;
		String user = req.getParameter("userid");
		String userpass = req.getParameter("userpass");

		dto.setUserid(req.getParameter("userid"));
		if(userpass != null || userpass != "") {
			dto.setUserpass(req.getParameter("userpass"));
		}
		dto.setUsername(req.getParameter("username"));
		dto.setUseremail(req.getParameter("useremail"));
		dto.setPostcode(Integer.parseInt(req.getParameter("postcode")));
		dto.setAddr(req.getParameter("addr"));
		dto.setDetailaddr(req.getParameter("detailaddr"));
		dto.setTel(req.getParameter("tel"));
		dto.setUip();
		dto.setWdate();
		boolean isSuccess = ddl.update(dto, user);
		
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();
		req.setCharacterEncoding("UTF-8");
		String script = null;
				
		if(isSuccess) {
			System.out.println("update is success");
			url = "index.jsp";
			res.sendRedirect(url);
		}else {
			System.out.println("update is failed");
			url = "?fname=member/edtregister";
			res.sendRedirect(url);
		}
		
		doGet(req, res);
	}


}
