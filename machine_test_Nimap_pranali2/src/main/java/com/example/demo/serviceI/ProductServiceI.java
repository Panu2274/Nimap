package com.example.demo.serviceI;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.model.Product;

public interface ProductServiceI {
    Page<Product> getAllProducts(Pageable pageable); // Get paginated products

    Product getProductById(Long id); // Get product by ID

    Product createProduct(Product product); // Create a new product

    Product updateProduct(Long id, Product product); // Update product by ID

    void deleteProduct(Long id); // Delete product by ID
}

