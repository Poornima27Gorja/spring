package com.lpu.users.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.lpu.users.entity.Product;

@FeignClient(name = "products", path = "/product")
public interface ProductFeignServiceClient {
	
	@GetMapping("/get-product")
	public String getProducts();
	
	@GetMapping("/find/{productId}")
	public Product findProduct(@PathVariable int productId);
	
	@GetMapping("/findAll")
	public List<Product> findAll();
	
	@PostMapping("/save")
	public Product saveProduct(@RequestBody Product product);

}