package com.codingdojo.dojoninja.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.dojoninja.models.Dojo;
import com.codingdojo.dojoninja.models.Ninja;
import com.codingdojo.dojoninja.repositories.NinjaRepository;

@Service		
public class NinjaService {
	//addind the ninja repository as a dependency
	private final NinjaRepository ninjaRepository;
	
	//constructor of NinjaService
	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	//return all the ninjas
	public List<Ninja> allNinja(){
		return ninjaRepository.findAll();
	}
	//create a ninja
	public Ninja createNinja(Ninja n) {
		return ninjaRepository.save(n);
	}
	//retrieve a ninja
	public Ninja findNinja(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
		if(optionalNinja.isPresent()) {
			return optionalNinja.get();
		} else {
			return null;
		}
	}
	//delete a ninja
	public void deleteNinja(Long id) {
		Ninja ninja = findNinja(id);
		ninjaRepository.delete(ninja);
	}
	//update a ninja
	public Ninja updateNinja(Long id, String firstName, String lastName, int age, Dojo dojo) {
		Ninja ninja = findNinja(id);
		ninja.setFirstName(firstName);
		ninja.setLastName(lastName);
		ninja.setAge(age);
		ninja.setDojo(dojo);
		ninjaRepository.save(ninja);
		return ninja;
	}
}
