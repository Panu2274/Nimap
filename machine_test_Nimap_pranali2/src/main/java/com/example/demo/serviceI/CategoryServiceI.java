package com.example.demo.serviceI;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.model.Category;

public interface CategoryServiceI {
    Page<Category> getAllCategories(Pageable pageable); // Get paginated categories

    Category getCategoryById(Long id); // Get category by ID

    Category createCategory(Category category); // Create a new category

    Category updateCategory(Long id, Category category); // Update category by ID

    void deleteCategory(Long id); // Delete category by ID
}

