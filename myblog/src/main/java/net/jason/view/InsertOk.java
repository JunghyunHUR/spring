package net.jason.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.jason.database.BlogDto;
import net.jason.database.BlogImpl;

@WebServlet("/insertok")
public class InsertOk extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.getWriter().append("Served at: ").append(req.getContextPath());
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession(true);
		BlogImpl blogfile =  new BlogImpl();
		BlogDto bDto = new BlogDto();
		PrintWriter out = res.getWriter();
		res.setContentType("text/html; charset=utf-8");
		req.setCharacterEncoding("utf-8");
		
		int imname = 0;
		if(session.getAttribute("imname") != null) imname = Integer.parseInt((String)session.getAttribute("imname"));
		bDto.setTitle(req.getParameter("title"));
		bDto.setContent(req.getParameter("content"));
		bDto.setWriter(req.getParameter("writer"));
		bDto.setCategorya(req.getParameter("categorya"));
		bDto.setCategoryb(req.getParameter("categoryb"));
		bDto.setImname(imname);
		int rs = blogfile.bInsert(bDto);
//		int rss = blogfile.fileUpdate(rs);
		
		//세션 아웃
		//이미지 if else 를 이용해서 바뀌도록 처리
		//관리자 모드 목록, 세부보기
		//관리자 모드에 로그인 ...
		out.print("등록했습니다.");
		doGet(req, res);
	}

}
