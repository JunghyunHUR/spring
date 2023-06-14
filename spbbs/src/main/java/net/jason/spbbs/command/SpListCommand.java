package net.jason.spbbs.command;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import net.jason.spbbs.dao.SpDao;
import net.jason.spbbs.dto.SpDto;

public class SpListCommand implements SpCommand {

	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String page = request.getParameter("page");
		if(page == null) page = "1";
		SpDao dao = new SpDao();
		
		ArrayList<SpDto> dtos = dao.list(page);
		model.addAttribute("list", dtos);
		

}

}
