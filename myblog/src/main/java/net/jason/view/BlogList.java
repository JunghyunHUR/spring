package net.jason.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import net.jason.database.BlogDto;
import net.jason.database.BlogImpl;

@WebServlet("/blist")
public class BlogList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BlogList() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String page = req.getParameter("page");
		int pg =1;
		if(page != null) {
			pg = Integer.parseInt(page);
		}
		res.setContentType("text/plain;charset=UTF-8");
		PrintWriter out = res.getWriter();
		
		BlogImpl blog = new BlogImpl();
		List<BlogDto> dto = blog.bList(pg);
		String gson = new Gson().toJson(dto);  //gson을 이용해 json 타입으로 변환
		out.println(gson);
		out.close();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
