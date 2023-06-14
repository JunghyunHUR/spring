package net.jason.hint;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AvailableTags extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   res.setContentType("application/json");
	   res.setCharacterEncoding("utf-8");
	   
	   String term = req.getParameter("term");
	   String q	= term.toLowerCase();
	   
	   List<String> tagsList = ReadTags.readAll(getServletContext());
	   List<String> filterTagsList = Utils.filterListByTerm(tagsList, q);
	   String json = Utils.list2Json(filterTagsList);
	   
	   res.getWriter().write(json);
	}

}
