package com.codingdojo.routing;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DojoController {
	@RequestMapping("/{param}")
	public String dojo(@PathVariable("param") String param){
		if(param == "dojo") {
			return "The "+param+" is awesome!";
		}else {
			if(param == "burbank-dojo") {
				return "Burbank Dojo is located in Southern CAlifornia";
			} else {
				if(param == "san-jose") {
					return "SJ dojo is the headquarters";
				} else {
					return "Nothing to display for "+param;
				}
			}
		}
			
	}
}
