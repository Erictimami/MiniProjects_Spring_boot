package com.codingdojo.relationships.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.relationships.models.License;
import com.codingdojo.relationships.models.Person;
import com.codingdojo.relationships.services.LicenseService;
import com.codingdojo.relationships.services.PersonService;

@Controller
public class RelationshipsController {
	private final PersonService personService;
	private final LicenseService licenseService;

	public RelationshipsController(PersonService personService, LicenseService licenseService) {
		this.personService = personService;
		this.licenseService = licenseService;
	}
	//get all persons
	@RequestMapping("/persons/all")
	public String index(Model model) {
		List<Person> persons = personService.allPersons();
		model.addAttribute("persons", persons);
		return "/person/index.jsp";
	}
	@RequestMapping("/licenses/all")
	public String indexl(Model model) {
		List<License> licenses = licenseService.allLicenses();
		model.addAttribute("licenses", licenses);
		return "/license/index.jsp";
	}

//	//get a person
//	@RequestMapping("/persons/{id}")
//	public String displayOne(@PathVariable("id") Long id, Model model) {
//		Person person = personService.findPerson(id);
//		model.addAttribute("person", person);
//		return "/person/show.jsp";
//	}
	//get a license
	@RequestMapping("/persons/{id}")
	public String displayOnel(@PathVariable("id") Long id, Model model) {
		License license = licenseService.findLicense(id);
		model.addAttribute("license", license);
		return "/license/show.jsp";
	}
	
	//display the .jsp file for new license
	@RequestMapping("/licenses/new")
	public String newl(Model model, @ModelAttribute("license") License license) {//@ModelAttribute(...) is important to reserve the space fo the model during the post
		List<Person> persons = personService.allPersons();
		model.addAttribute("persons", persons);
		return "/license/newLicense.jsp";
	}

	//post a license
	@RequestMapping(value="/licenses/new/process", method=RequestMethod.POST)
	public String createl(@Valid @ModelAttribute("license") License license, BindingResult result, RedirectAttributes errors) {
		if(result.hasErrors()) {
			errors.addFlashAttribute("errores", result.getAllErrors());
			return "license/newLicense.jsp";
		} else {
			licenseService.createLicense(license);
			return "redirect:/licenses/all";
		}
	}
	
	//display the .jsp file for new person
	@RequestMapping("/persons/new")
	public String newp(@ModelAttribute("person") Person person) {//@ModelAttribute(...) is important to reserve the space fo the model during the post
		return "/person/newPerson.jsp";
	}
	
	//post a person
	@RequestMapping(value="/persons/new/process", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if(result.hasErrors()) {
			return "person/newPerson.jsp";
		} else {
			personService.createPerson(person);
			return "redirect:/licenses/all";
		}
	}
}
