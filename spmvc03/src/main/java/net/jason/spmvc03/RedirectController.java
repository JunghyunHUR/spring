package net.jason.spmvc03;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectController {
	
	@RequestMapping("/student")
	public String studentRedirect(HttpServletRequest httpServletRequest, Model model) {
		
		String id = httpServletRequest.getParameter("id");
		if(id.equals("admin")) {
			return "redirect:studentAdmin";
		}
		return "redirect:studentOk";
	}
	
	@RequestMapping("/studentAdmin")
	public String studentAdmin(Model model) {
		return "student/studentAdmin";
	}
	
	@RequestMapping("/studentOk")
	public String studentOk(Model model) {
		return "student/studentOk";
	}
	
}
