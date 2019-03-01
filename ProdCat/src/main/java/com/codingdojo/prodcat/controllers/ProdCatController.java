package com.codingdojo.prodcat.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.prodcat.models.Category;
import com.codingdojo.prodcat.models.CategoryProduct;
import com.codingdojo.prodcat.models.Product;
import com.codingdojo.prodcat.services.CategoryProductService;
import com.codingdojo.prodcat.services.CategoryService;
import com.codingdojo.prodcat.services.ProductService;

@Controller
public class ProdCatController {
	private ProductService productService;
	private CategoryService categoryService;
	private CategoryProductService categoryProductService;
	
	//contructor
	public ProdCatController(ProductService productService, CategoryService categoryService,
			CategoryProductService categoryProductService) {
		this.productService = productService;
		this.categoryService = categoryService;
		this.categoryProductService = categoryProductService;
	}
	//display the form for a new Product
	@RequestMapping("/products/new")
	public String newp(@ModelAttribute("product") Product product) {
		return "/product/newProduct.jsp";
	}
	//post a new product
	@RequestMapping(value="/products/new/process", method=RequestMethod.POST)
	public String createp(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("Error creation product: "+product);
			return "redirect:/products/new";
		} else {
			System.out.println("Creation Product Success");
			productService.createProduct(product);
			return "redirect:/products";
		}
	}
	//display the form for a new category
	@RequestMapping("/categories/new")
	public String newc(@ModelAttribute("category") Category category) {
		return "/category/newCategory.jsp";
	}
	//post a new Category
	@RequestMapping(value="/categories/new/process", method=RequestMethod.POST)
	public String createp(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("Error creation Category: "+category);
			return "redirect:/categories/new";
		} else {
			System.out.println("Creation Category Success");
			categoryService.createCategory(category);
			return "redirect:/categories";
		}
	}
	//display all the products 
	@RequestMapping("/products")
	public String indexp(Model model) {
		List<Product> products = productService.allProducts();
		model.addAttribute("products", products);
		List<Category> categories = categoryService.allCategories();
		model.addAttribute("categories", categories);
		System.out.println("Display all the products: "+products);
		return "/product/products.jsp";
	}
	//display all the Categories
	@RequestMapping("/categories")
	public String indexc(Model model) {
		List<Category> categories = categoryService.allCategories();
		model.addAttribute("categories", categories);
		List<Product> products = productService.allProducts();
		model.addAttribute("products", products);
		System.out.println("Display all the Categories: "+categories);
		return "/category/categories.jsp";
	}
	//display a product and the form for categories
	@RequestMapping("/products/{id}")
	public String indexp(@PathVariable("id") Long id, Model model, @ModelAttribute("categoryProduct") CategoryProduct categoryProduct, BindingResult result) {
		Product product = productService.findProduct(id);
		model.addAttribute("product", product);
		List<Category> categories = categoryService.allCategories();
		model.addAttribute("categories", categories);
		System.out.println("Display a product: "+product);
		return "/product/product.jsp";
	}
	//display all the Categories and the form for ProdCat
	@RequestMapping("/categories/{id}")
	public String indexc(@PathVariable("id") Long id, Model model, @ModelAttribute("categoryProduct") CategoryProduct categoryProduct, BindingResult result) {
		Category category = categoryService.findCategory(id);
		model.addAttribute("category", category);
		List<Product> products = productService.allProducts();
		model.addAttribute("products", products);
		System.out.println("Display a Category: "+category);
		return "/category/category.jsp";
	}
	//post a category into a product
	@RequestMapping(value="/product/prodCat/process", method=RequestMethod.POST)
	public String createProdCatp(@RequestParam("prodID") Long id, @Valid @ModelAttribute("categoryProduct") CategoryProduct categoryProduct, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println("Error creation prodCat");
			System.out.println(categoryProduct.getProduct().getName());
			return "redirect:/products";
		} else {
			categoryProduct.setProduct(productService.findProduct(id));
			categoryProductService.createCategoryProduct(categoryProduct);
			System.out.println("TESY=TT");
			return "redirect:/products";
		}
	}
	//post a product into a categories
	@RequestMapping(value="/category/prodCat/process", method=RequestMethod.POST)
	public String createProdCatc(@RequestParam("catID") Long id, @Valid @ModelAttribute("categoryProduct") CategoryProduct categoryProduct, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println(result);
			System.out.println("Error creation prodCat");
			System.out.println(categoryProduct.getProduct().getName());
			System.out.println(categoryProduct.getCategory().getName());


			return "redirect:/categories";
		} else {
			categoryProduct.setCategory(categoryService.findCategory(id));
			categoryProductService.createCategoryProduct(categoryProduct);
			return "redirect:/categories";
		}
	}
	
}
