package com.codingdojo.prodcat.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.prodcat.models.Product;
@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{
	List<Product> findAll();
    // this method find a book by their description
//  List<Book> findByDescriptionContaining(String search);
//  // this method counts how many titles contain a certain string
//  Long countByTitleContaining(String search);
//  // this method deletes a book that starts with a specific title
//  Long deleteByTitleStartingWith(String search);

}
