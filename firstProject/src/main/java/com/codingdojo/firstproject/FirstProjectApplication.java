package com.codingdojo.firstproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController //this is an annotation just to let know that this is the controller file
public class FirstProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstProjectApplication.class, args);
	}
	
	@RequestMapping("/")//this is an annotation to response to the route request
	//method that maps to the request route above
	public String hello() {
		return "Hello World";
	}
}
