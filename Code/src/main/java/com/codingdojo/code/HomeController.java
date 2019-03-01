package com.codingdojo.code;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
	public static String code="bushido";
	
	@RequestMapping("/")
	public String home() {
		return "index.jsp";
	}
	@RequestMapping(value="/process", method=RequestMethod.POST)
	public String process(@RequestParam(value="code") String to_check) {
		if(to_check.equals(code) != true) {
			System.out.println(to_check);
			return "redirect:/errorRoute";
		}
		return "redirect:/code";
	}
	@RequestMapping("/code")
	public String code() {
		return "code.jsp";
	}
	@RequestMapping("/errorRoute")//this is not the same error with this below. this is the root name, this below is the variable name for flash in the index.jsp page
	public String flashMessages(RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("errorName", "You must train harder");
		return "redirect:/";
	}
	
	
}
