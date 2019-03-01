package com.codingdojo.relationships.services;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.relationships.models.License;
import com.codingdojo.relationships.models.Person;
import com.codingdojo.relationships.repositories.LicenseRepository;

@Service
public class LicenseService {
	//adding the License repository as a dependency
	private final LicenseRepository licenseRepository;
	
	public LicenseService(LicenseRepository licenseRepository) {
		this.licenseRepository = licenseRepository;
	}
	//return all the Licenses
	public List<License> allLicenses(){
		return licenseRepository.findAll();
	}
	//creates a License
	public License createLicense(License l) {
		return licenseRepository.save(l);
	}
	//retrieve a License
	public License findLicense(Long id) {
		Optional<License> optionalLicense = licenseRepository.findById(id);
		if(optionalLicense.isPresent()) {
			return optionalLicense.get();
		} else {
			return null;
		}
	}
	//delete a License
	public void deleteLicense(Long id) {
		License license = findLicense(id);
		licenseRepository.delete(license);
	}
	//update a License
	public License updateLicense(Long id, String number, String expirationDate, String state, Person person) {
		License license = findLicense(id);
		license.setNumber(number);
		license.setExpirationDate(expirationDate);
		license.setState(state);
		license.setPerson(person);
		licenseRepository.save(license);
		return license;
	}
}
