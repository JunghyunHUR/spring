package net.jason.spbbs.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.jason.spbbs.command.SpCommand;
import net.jason.spbbs.command.SpDelCommand;
import net.jason.spbbs.command.SpDetailCommand;
import net.jason.spbbs.command.SpListCommand;
import net.jason.spbbs.command.SpReplyCommand;
import net.jason.spbbs.command.SpReplyokCommand;
import net.jason.spbbs.command.SpUpdateCommand;
import net.jason.spbbs.command.SpUpdateokCommand;
import net.jason.spbbs.command.SpWriteCommand;
import net.jason.spbbs.dto.PageDto;
import net.jason.spbbs.util.Pagenation;
import net.jason.spbbs.util.Static;

@Controller
public class SpController {
	
	//모든 command가 갖고있는 인터페이스 타입을 선언
	SpCommand command;
	
	//jdbc Spring template
	public JdbcTemplate template;
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Static.template = this.template;
	}
	
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model){
		System.out.println("list() 실행");
		model.addAttribute("request", request);
		
		command = new SpListCommand();
		command.execute(model);
		
		PageDto pdto = new PageDto();
		Pagenation pages = new Pagenation();
		pages.setDisplayPageNum(10);
		pages.setPdto(pdto);
		pages.setTotalCount();
		model.addAttribute("pages", pages);
		return "list";
	}
	
	@RequestMapping("/detail")
	public String detail(HttpServletRequest request, Model model) {
			System.out.println("detail() 실행");
			model.addAttribute("request", request);

			command = new SpDetailCommand();
			command.execute(model);
			return "detail";
	}
	
	@RequestMapping("/write")
	public String write(Model model) {
		System.out.println("write() 실행");
		return "write";
	}
	
	@RequestMapping(value="/writeok", method=RequestMethod.POST)
	public String writeok(HttpServletRequest request, Model model) {
		System.out.println("writeok() 실행");
		
		model.addAttribute("request", request);
		command = new SpWriteCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/reply")
	public String reply(HttpServletRequest request, Model model) {
		System.out.println("reply() 실행");
		
		model.addAttribute("request", request);
		command = new SpReplyCommand();
		command.execute(model);
		
		return "reply";
	}
	
	@RequestMapping(value="/replyok", method=RequestMethod.POST)
	public String replyok(HttpServletRequest request, Model model) {
		System.out.println("replyok() 실행");
		model.addAttribute("request", request);
		
		command = new SpReplyokCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/update")
	public String update(HttpServletRequest request, Model model){
		System.out.println("update() 실행");
		model.addAttribute("request", request);
		
		command = new SpUpdateCommand();
		command.execute(model);
		
		return "update";
	}
	
	@RequestMapping(value="/updateok", method=RequestMethod.POST)
	public String updateok(HttpServletRequest request, Model model) {
		System.out.println("updateok() 실행");
		model.addAttribute("request", request);
		
		command = new SpUpdateokCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/del")
	public String del(HttpServletRequest request, Model model) {
		System.out.println("del() 실행");
		model.addAttribute("request", request);
		
		command = new SpDelCommand();
		command.execute(model);
		
		return "redirect:list";
	}
}
