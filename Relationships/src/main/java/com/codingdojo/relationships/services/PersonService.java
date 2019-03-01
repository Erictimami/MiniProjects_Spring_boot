package com.codingdojo.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.relationships.models.Person;
import com.codingdojo.relationships.repositories.PersonRepository;

@Service
public class PersonService {
	//adding the person repository as a dependency
	private final PersonRepository personRepository;
	
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	//return all the persons
	public List<Person> allPersons(){
		return personRepository.findAll();
	}
	//creates a person
	public Person createPerson(Person p) {
		return personRepository.save(p);
	}
	//retrieve a person
	public Person findPerson(Long id) {
		Optional<Person> optionalPerson = personRepository.findById(id);
		if(optionalPerson.isPresent()) {
			return optionalPerson.get();
		} else {
			return null;
		}
	}
	//delete a person
	public void deletePerson(Long id) {
		Person person = findPerson(id);
		personRepository.delete(person);
	}
	//update a person
	public Person updatePerson(Long id, String firstName, String lastName) {
		Person person = findPerson(id);
		person.setFirstName(firstName);
		person.setLastName(lastName);
		personRepository.save(person);
		return person;
	}
}
