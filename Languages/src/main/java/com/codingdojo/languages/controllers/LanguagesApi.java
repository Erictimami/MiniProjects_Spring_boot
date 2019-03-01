package com.codingdojo.languages.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.languages.models.Language;
import com.codingdojo.languages.services.LanguageService;

@RestController
public class LanguagesApi {
	private final LanguageService languageService;
	
	//constructor
	public LanguagesApi(LanguageService languageService){
		this.languageService = languageService;
	}
	//find all the languages
	@RequestMapping("/api/languages")
	public List<Language> index(){
		return languageService.allLanguages();
	}
	//post a language
	@RequestMapping(value ="/api/languages", method=RequestMethod.POST)
	public Language create(@RequestParam(value="name") String name, @RequestParam(value="creator") String creator, @RequestParam(value="version") String version) {
		Language language = new Language(name, creator, version);
		return languageService.createLanguage(language);
	}
	//find a specific language
	@RequestMapping("/api/languages/{id}")
	public Language show(@PathVariable(value="id") Long id) {
		Language language = languageService.findLanguage(id);
		return language;
	}
	//update a language
	@RequestMapping(value="/api/languages/updateLanguage/{id}", method =RequestMethod.PUT)
	public Language update(@PathVariable("id") Long id, @RequestParam(value="name") String name, @RequestParam(value="creator") String creator, @RequestParam(value="version") String version) {
		Language language = languageService.updateLanguage(id, name, creator, version);
		return language;
	}
	//delete a language
	@RequestMapping(value="/api/languages/deleteLanguage/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		languageService.deleteLanguage(id);
	}
}
