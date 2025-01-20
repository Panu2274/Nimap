package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Product;




public interface ProductRepositoryy extends JpaRepository<Product, Long> {
}

	