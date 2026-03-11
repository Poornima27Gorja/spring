package com.lpu.product.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.lpu.product.entity.Product;
import com.lpu.product.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public Product add(@RequestBody Product product) {
        return service.save(product);
    }

    @GetMapping("/get")
    public List<Product> getAll() {
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    public Product get(@PathVariable Long id) {
        return service.get(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}