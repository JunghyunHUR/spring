

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.MemberDDL;
import board.MembersDTO;

public class FindIdPw extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.getWriter().append("Served at: ").append(req.getContextPath());
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		MemberDDL ddl = new MemberDDL();
		int opt = Integer.parseInt(req.getParameter("opt"));
		String val1 = null, val2 = null, rs1 = null, rs2 = null;
		
		if(opt == 1) {
			val1 = req.getParameter("username");
		}else if(opt == 2) {
			val1 = req.getParameter("userid");
		}
		val2 = req.getParameter("useremail");
		
		Vector data = ddl.getSelect(val1, val2, opt);
		
		int size = data.size();
		for(int i = 0; i < size; i++) {
			MembersDTO dt = (MembersDTO) data.elementAt(i);
			rs1 = dt.getUserid();
			rs2 = dt.getUserpass();
		}
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();
		req.setCharacterEncoding("UTF-8");
		out.println("<html><head><title>>아이디/패스워드 검색</title>");
		out.println("<link href='css/bootstrap.css />");
		out.println("</head><body><div class='container text-center'>");
		if(size == 0) {
			if(opt ==1) {
				out.println("<div class='text-center'> 아이디를 찾을 수 없습니다.</div>");
				out.println("<a href='/board/member/findIdPw.jsp'>다시시도</a>");
				out.println("<a href='javascript:void(0)' onclick='javascript:self.close()'>닫기</a>");
			}else {
				out.println("<div class='text-center'> 비밀번호를 찾을 수 없습니다.</div>");
				out.println("<a href='/board/member/findIdPw.jsp'>다시시도</a>");
				out.println("<a href='javascript:void(0)' onclick='javascript:self.close()'>닫기</a>");
			}
		}else {
			if(opt == 1) {
				out.println("<p>고객님의 아이디는");
				out.println(rs1);
				out.println("입니다.</p>");
				out.println("<p><a href=\"javascript:void(0)\" onclick=\"opener.document.getElementById('userid').value='"+rs1+"'; self.close();\">");
				out.println("아이디 사용</a></p>");
			}else {
				out.println("<p>고객님의 비밀번호는");
				out.println(rs2);
				out.println("입니다.</p>");
				out.println("<p><a href=\"javascript:void(0)\" onclick=\"opener.document.getElementById('userpass').value='"+rs2+"'; self.close();\"Z>");
				out.println("비밀번호 사용</a></p>");
			}
			out.println("</div></body></html>");
		}
		
		
		
	}

}
