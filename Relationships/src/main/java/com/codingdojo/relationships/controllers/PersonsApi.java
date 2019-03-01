package com.codingdojo.relationships.controllers;


import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.relationships.models.License;
import com.codingdojo.relationships.models.Person;
import com.codingdojo.relationships.services.LicenseService;
import com.codingdojo.relationships.services.PersonService;

@RestController
public class PersonsApi {
	private final PersonService personService;
	private final LicenseService licenseService;
	
	//constructor
	public PersonsApi(PersonService personService, LicenseService licenseService){
		this.personService = personService;
		this.licenseService = licenseService;
	}
	//find all the persons
	@RequestMapping("/api/persons")
	public List<Person> index(){
		return personService.allPersons();
	}
	//post a person
	@RequestMapping(value ="/api/persons", method=RequestMethod.POST)
	public Person create(@RequestParam(value="firstName") String firstName, @RequestParam(value="lastName") String lastName) {
		Person person = new Person(firstName, lastName);
		return personService.createPerson(person);
	}
	//find a specific person
	@RequestMapping("/api/persons/{id}")
	public Person show(@PathVariable(value="id") Long id) {
		Person person = personService.findPerson(id);
		return person;
	}
	//update a person
	@RequestMapping(value="/api/persons/updatePerson/{id}", method =RequestMethod.PUT)
	public Person update(@PathVariable("id") Long id, @RequestParam(value="firstName") String firstName, @RequestParam(value="lastName") String lastName) {
		Person person = personService.updatePerson(id, firstName, lastName);
		return person;
	}
	//delete a person
	@RequestMapping(value="/api/persons/deletePerson/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		personService.deletePerson(id);
	}

	//find all the Licenses
	@RequestMapping("/api/licenses")
	public List<License> index2(){
		return licenseService.allLicenses();
	}
	//post a License
	@RequestMapping(value ="/api/licenses/{id}", method=RequestMethod.POST)
	public License create(@PathVariable("id") Long id, @RequestParam(value="number") String number, @RequestParam(value="expirationDate") String expirationDate, @RequestParam(value="state") String state) {
		License license = new License(number, expirationDate, state);
		license.setPerson(show(id));//request to have the person of the id
		return licenseService.createLicense(license); // we save it here
	}
	//find a specific License
	@RequestMapping("/api/licenses/{id}")
	public License show2(@PathVariable(value="id") Long id) {
		License license = licenseService.findLicense(id);
		return license;
	}
	//update a License
	@RequestMapping(value="/api/licenses/updateLicense/{id}", method =RequestMethod.PUT)
	public License update(@PathVariable("id") Long id, @RequestParam(value="number") String number, @RequestParam(value="expirationDate") String expirationDate, @RequestParam(value="state") String state) {
		License license = licenseService.updateLicense(id, number, expirationDate, state, show(id));
		return license;
	}
	//delete a License
	@RequestMapping(value="/api/licenses/deleteLicense/{id}", method = RequestMethod.DELETE)
	public void delete2(@PathVariable("id") Long id) {
		licenseService.deleteLicense(id);
	}
}
