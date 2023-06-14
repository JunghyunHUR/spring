package net.jason.spmvc03;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/search")
	public String search() {
		
		return "search";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="searchok")
	public String searchok(HttpServletRequest req, Model model) {
		String search = req.getParameter("search");
		model.addAttribute("search", search);
		return "searchok";
	}
	
	@RequestMapping("/member")
	public String member() {
		
		return "member";
	}
	
//	@RequestMapping("/memberok")
//	public String memberok(HttpServletRequest req, Model model) {
//		Member mb = new Member();
//		mb.setUserid(req.getParameter("userid"));
//		mb.setUserpass(req.getParameter("userpass"));
//		mb.setUsername(req.getParameter("username"));
//		model.addAttribute("mem", mb);
//		
//		return "memberok";
//	}
	
//	@RequestMapping("/memberok")
//	public String memberok(
//			@RequestParam("userid") String userid,
//			@RequestParam("username") String username,
//			@RequestParam("userpass") String userpass,
//			Model model) {
//		Member mb = new Member();
//		mb.setUserid(userid);
//		mb.setUserpass(userpass);
//		mb.setUsername(username);
//		model.addAttribute("mem", mb);
//		
//		return "memberok";
//	}
	
	@RequestMapping("/memberok")
	public String memberok(@ModelAttribute("mem") Member member) {
		return "memberok";
	}
	
}
