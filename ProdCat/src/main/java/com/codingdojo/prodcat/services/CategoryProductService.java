package com.codingdojo.prodcat.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.prodcat.models.Category;
import com.codingdojo.prodcat.models.CategoryProduct;
import com.codingdojo.prodcat.models.Product;
import com.codingdojo.prodcat.repositories.CategoryProductRepository;
@Service
public class CategoryProductService {
	
	private final CategoryProductRepository categoryProductRepository;
	
	public CategoryProductService(CategoryProductRepository categoryProductRepository) {
		this.categoryProductRepository = categoryProductRepository;
	}
	
	//return allthe CategoryProduct
	public List<CategoryProduct> allCategoryProducts(){
		return categoryProductRepository.findAll();
	}
	//creates a CategoryProduct
	public CategoryProduct createCategoryProduct(CategoryProduct c) {
		return categoryProductRepository.save(c);
	}
	//retrieve a CategoryProduct
	public CategoryProduct findCategoryProduct(Long id) {
		Optional<CategoryProduct> optionalCategoryProduct = categoryProductRepository.findById(id);
		if(optionalCategoryProduct.isPresent()) {
			return optionalCategoryProduct.get();
		} else {
			return null;
		}
	}
	//delete a CategoryProduct
	public void deleteCategoryProduct(Long id) {
		CategoryProduct categoryProduct = findCategoryProduct(id);
		categoryProductRepository.delete(categoryProduct);
	}
	//update a CategoryProduct
	public CategoryProduct updateCategoryProduct(Long id, Product product, Category category) {
		CategoryProduct categoryProduct = findCategoryProduct(id);
		categoryProduct.setCategory(category);
		categoryProduct.setProduct(product);
		categoryProductRepository.save(categoryProduct);
		return categoryProduct;
	}
}
