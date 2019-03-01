package com.codingdojo.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/your_server")
public class HomeController {
	public static int count;
	
	@RequestMapping("")
	public String home(HttpSession session){
		if(session.getAttribute("count") ==null) {
			count = 0;
			session.setAttribute("count", count);
		}
		count+=1;

		return "index.jsp";
	}
	@RequestMapping("/counter")
	public String counter(HttpSession session) {
		session.setAttribute("count", count);
		return "counter.jsp";
	}
	
}
