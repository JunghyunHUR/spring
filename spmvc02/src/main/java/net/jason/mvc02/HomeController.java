package net.jason.mvc02;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/bbs/view.do")
	public String view() {
		
		return "bbs/view";
	}
	
	@RequestMapping("/bbs/content.do")
	public String content(Model model) {
		
		model.addAttribute("user", "È«±æµ¿");
		return "bbs/content";
	}
	
	@RequestMapping("/bbs/reply.do")
	public ModelAndView reply() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("users", "È«¾¾ Áý¾È »ç¶÷µé");
		mv.addObject("age", 40);
		mv.setViewName("bbs/reply");
		
		return mv;
	}
	
	@RequestMapping("/search/search.do")
	public String search(HttpServletRequest req, Model model) {
		String search = req.getParameter("search");
		model.addAttribute("search", search);
		return "search/search";
		
	}
	
//	@RequestMapping("/search/search.do")
//	public String search(@RequestParam("search") String search, Model model) {
//		model.addAttribute("search", search);
//		return "search/search";
//	}
	
	@RequestMapping("/member/register.do")
	public String register() {
		return "member/register";
	}
	
//	@RequestMapping("/member/registerok.do")
//	public String registerok(
//			@RequestParam("userName") String userName,
//			@RequestParam("userId") String userId,
//			@RequestParam("userPass") String userPass,			
//			@RequestParam("userEmail") String userEmail,			
//			@RequestParam("userMobile") String userMobile,
//			Model model
//	) {
//		Register rg = new Register();
//		rg.setUserId(userId);
//		rg.setUserPass(userPass);
//		rg.setUserName(userName);
//		rg.setUserEmail(userEmail);
//		rg.setUserMobile(userMobile);
//		
//		model.addAttribute("member", rg);
//		return "member/registerok";
//	}

//	@RequestMapping("/member/registerok.do")
//	public String registerok(HttpServletRequest req, Model model) {
//		Register rg = new Register();
//		rg.setUserId(req.getParameter("userId"));
//		rg.setUserPass(req.getParameter("userPass"));
//		rg.setUserName(req.getParameter("userName"));
//		rg.setUserEmail(req.getParameter("userEmail"));
//		rg.setUserMobile(req.getParameter("userMobile"));
//		
//		model.addAttribute("member", rg);
//		
//		return "member/registerok";
//	}
	
	@RequestMapping("/member/registerok.do")
	public String registerok(Register register) {
		
		return "member/registerok";
	}
	
}
