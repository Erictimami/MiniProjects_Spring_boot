package com.codingdojo.dojoninja.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.dojoninja.models.Dojo;
import com.codingdojo.dojoninja.models.Ninja;
import com.codingdojo.dojoninja.services.DojoService;
import com.codingdojo.dojoninja.services.NinjaService;

@Controller
public class DojoNinjaController {
	private final DojoService dojoService;
	private final NinjaService ninjaService;
	
	//constructor of DojoNinjaController
	public DojoNinjaController(DojoService dojoService, NinjaService ninjaService) {
		this.dojoService = dojoService;
		this.ninjaService = ninjaService;
	}
	//get all dojos
	@RequestMapping("/dojos/all")
	public String indexd(Model model) {
		List<Dojo> dojos = dojoService.allDojos();
		model.addAttribute("dojos", dojos);
		System.out.println("dojos all: "+dojos);
		return "/dojo/allDojos.jsp";
	}
	@RequestMapping("/ninjas/all")
	public String indexn(Model model) {
		List<Ninja> ninjas = ninjaService.allNinja();
		model.addAttribute("ninjas", ninjas);
		System.out.println("ninjas all: "+ninjas);
		return "/dojo/allDojos.jsp";
	}
	//get a dojo
	@RequestMapping("/dojos/{id}")
	public String displayOned(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dojoService.findDojo(id);
		model.addAttribute("dojo", dojo);
		System.out.println("dojo one: "+dojo);
		return "/dojo/oneDojo.jsp";
	}
//	//get a Ninja
//	@RequestMapping("/ninjas/{id}")
//	public String displayOnen(@PathVariable("id") Long id, Model model) {
//		Ninja ninja = ninjaService.findNinja(id);
//		model.addAttribute("ninja", ninja);
//		System.out.println("ninja one: "+ninja);
//		return "/ninja/oneNinja.jsp";
//	}
	//display the .jsp file for the new ninja
	@RequestMapping("/ninjas/new")
	public String newn(Model model, @ModelAttribute("ninja") Ninja ninja) {
		List<Dojo> dojos = dojoService.allDojos();
		model.addAttribute("dojos", dojos);
		return "/ninja/newNinja.jsp";
	}
	//post a ninja
	@RequestMapping(value="/ninjas/new/process", method=RequestMethod.POST)
	public String createn(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("error TestE: "+ninja);
			return "redirect:/ninjas/new";
		} else {
			System.out.println("****Ninja****");
			System.out.println(ninja.getDojo());
			System.out.println("new ninja: "+ninja);
			ninjaService.createNinja(ninja);
			return "redirect:/dojos/all";
		}
	}
	//display the .jsp file for new dojo
	@RequestMapping("/dojos/new")
	public String newd(@ModelAttribute("dojo") Dojo dojo) {
		return "/dojo/newDojo.jsp";
	}
	//post a dojo
	@RequestMapping(value="/dojos/new/process", method=RequestMethod.POST)
	public String created(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "/dojo/newDojo.jsp";
		}else {
			dojoService.createDojo(dojo);
			return "redirect:/ninjas/all";
		}
	}
}


