package com.codingdojo.prodcat.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.prodcat.models.Product;
import com.codingdojo.prodcat.repositories.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository productRepository;
	
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	//return all the products
	public List<Product> allProducts(){
		return productRepository.findAll();
	}
	//creates a product
	public Product createProduct(Product p) {
		return productRepository.save(p);
	}
	//retrieve a Product
	public Product findProduct(Long id) {
		Optional<Product> optionalProduct = productRepository.findById(id);
		if(optionalProduct.isPresent()) {
			return optionalProduct.get();
		} else {
			return null;
		}
	}
	//delete a Product
	public void deleteProduct(Long id) {
		Product product = findProduct(id);
		productRepository.delete(product);
	}
	//update a Product
	public Product updateProduct(Long id, String name, String description, float price) {
		Product product = findProduct(id);
		product.setName(name);
		product.setDescription(description);
		product.setPrice(price);
		productRepository.save(product);
		return product;
	}

}
