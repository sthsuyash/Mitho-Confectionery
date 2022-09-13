package com.suyash.ecommerce.service;

import com.suyash.ecommerce.model.Category;
import com.suyash.ecommerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    // add category
    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    // return all categories from database
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    // delete category by id
    public void deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);
    }

    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }
}
