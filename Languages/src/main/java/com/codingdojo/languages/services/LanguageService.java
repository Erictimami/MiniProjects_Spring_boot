package com.codingdojo.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.languages.models.Language;
import com.codingdojo.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	private final LanguageRepository languageRepository;
	//the constructor of the languageService
	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	//return all the languages
	public List<Language> allLanguages(){
		return languageRepository.findAll();
	}
	//create or save a language
	public Language createLanguage(Language l) {
		return languageRepository.save(l);
	}
	// find a specific language
	public Language findLanguage(Long id) {
		Optional<Language> optionalLanguage = languageRepository.findById(id);
		if(optionalLanguage.isPresent()) {
			return optionalLanguage.get();
		} else {
			return null;
		}
	}
	//delete a language
	public void deleteLanguage(Long id) {
		Language language = findLanguage(id);
		languageRepository.delete(language);
	}
	//update a language
	public Language updateLanguage(Long id, String name, String creator, String version) {
		Language language = findLanguage(id);
		language.setName(name);
		language.setCreator(creator);
		language.setVersion(version);
		languageRepository.save(language);
		return language;
	
	}
}
