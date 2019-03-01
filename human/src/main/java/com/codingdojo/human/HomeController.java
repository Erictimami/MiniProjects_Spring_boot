package com.codingdojo.human;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@RequestMapping("/your_server")
	public String index(@RequestParam(value="name", required=false) String name) {
//		request.setAttribute("name", name);
//		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
		if(name == null) {
			return "<h2>Hello Human!</h2> <br> <br> <p>Welcome to SpringBoot!</p>";
		}
		else {
			return "<h2>Hello "+name+"!</h2> <br> <br> <p>Welcome to SpringBoot!</p>";
		}
	}
}
