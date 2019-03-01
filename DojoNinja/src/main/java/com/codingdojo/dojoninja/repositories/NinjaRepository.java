package com.codingdojo.dojoninja.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.dojoninja.models.Ninja;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long>{
	List<Ninja> findAll();
//  // this method find a book by their description
//  List<Book> findByDescriptionContaining(String search);
//  // this method counts how many titles contain a certain string
//  Long countByTitleContaining(String search);
//  // this method deletes a book that starts with a specific title
//  Long deleteByTitleStartingWith(String search);
}
