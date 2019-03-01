package com.codingdojo.dojoninja.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.dojoninja.models.Dojo;
import com.codingdojo.dojoninja.repositories.DojoRepository;

@Service
public class DojoService {
	
	private final DojoRepository dojoRepository;
	
	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}
	
	//return allthe dojo
	public List<Dojo> allDojos(){
		return dojoRepository.findAll();
	}
	//creates a dojo
	public Dojo createDojo(Dojo j) {
		return dojoRepository.save(j);
	}
	//retrieve a dojo
	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepository.findById(id);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		} else {
			return null;
		}
	}
	//delete a dojo
	public void deleteDojo(Long id) {
		Dojo dojo = findDojo(id);
		dojoRepository.delete(dojo);
	}
	//update a dojo
	public Dojo updateDojo(Long id, String name) {
		Dojo dojo = findDojo(id);
		dojo.setName(name);
		dojoRepository.save(dojo);
		return dojo;
	}
}
