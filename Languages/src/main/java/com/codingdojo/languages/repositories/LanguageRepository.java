package com.codingdojo.languages.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.languages.models.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long>{  //Long is the type of our id
	
	// this method retrieves all the books from the database
	List<Language> findAll();
   
}