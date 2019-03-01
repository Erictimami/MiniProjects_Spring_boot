package com.codingdojo.dojosurvey;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
	public static String name;
	public static String language;
	public static String location;
	public static String comment;
	
	@RequestMapping("/")
	public String home() {
		return "index.jsp";
	}
	@RequestMapping(value="/process", method=RequestMethod.POST)
	public String process(@RequestParam(value="name") String Name, @RequestParam(value="location") String Location, @RequestParam(value="language") String Language, @RequestParam(value="comment") String Comment) {
		if (Name.length() == 0) {
			return "redirect:/errorRoute";
		}
		name=Name;
		language=Language;
		location = Location;
		comment = Comment;
		System.out.println(Name+" "+Language);
		return "redirect:/result";
	}
	
	@RequestMapping("/result")
	public String result(Model model) {
		model.addAttribute("name", name);
		model.addAttribute("language", language);
		model.addAttribute("location", location);
		model.addAttribute("comment", comment);
		return "result.jsp";
	}
	@RequestMapping("/errorRoute")
	public String flashMessages(RedirectAttributes redirectAttributes) {
		System.out.println("ErrorRoute");
		redirectAttributes.addFlashAttribute("errorName", "Your name is required!");
		return "redirect:/";
	}
}
