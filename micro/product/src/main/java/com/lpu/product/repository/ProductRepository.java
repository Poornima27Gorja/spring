package com.lpu.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lpu.product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}