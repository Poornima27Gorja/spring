package com.lpu.products.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpu.products.entity.Product;
import com.lpu.products.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	public Product saveProduct(Product product) {
		return repository.save(product);
	}
	
	public Product findProductById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public List<Product> findAllProducts() {
		return repository.findAll();
	}
	
	public Product updateProductById(int id,Product product) {
		Product p = repository.findById(id).orElse(null);
		
		p.setProductName(product.getProductName());
		p.setPrice(product.getPrice());
		
		return repository.save(p);
	}
	
	public void deleteProductById(int id) {
		repository.deleteById(id);
	}
	
}
