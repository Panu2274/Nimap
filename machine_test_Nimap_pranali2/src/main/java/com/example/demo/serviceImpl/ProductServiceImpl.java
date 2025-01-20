package com.example.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.repo.CategoryRepositoryy;
import com.example.demo.repo.ProductRepositoryy;
import com.example.demo.serviceI.ProductServiceI;

@Service
public class ProductServiceImpl implements ProductServiceI {

    @Autowired
    private ProductRepositoryy productRepository;

    @Autowired
    private CategoryRepositoryy categoryRepository;

    @Override
    public Page<Product> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    @Override
    public Product createProduct(Product product) {
        // Ensure category exists before saving the product
        Long categoryId = product.getCategory().getId();
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + categoryId));

        product.setCategory(category); // Assign category to product
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Product existingProduct = getProductById(id);

        // Update fields
        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());

        // Update category if provided
        if (product.getCategory() != null) {
            Long categoryId = product.getCategory().getId();
            Category category = categoryRepository.findById(categoryId)
                    .orElseThrow(() -> new RuntimeException("Category not found with id: " + categoryId));
            existingProduct.setCategory(category);
        }

        return productRepository.save(existingProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}

