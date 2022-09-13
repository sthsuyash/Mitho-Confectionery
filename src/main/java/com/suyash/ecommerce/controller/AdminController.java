package com.suyash.ecommerce.controller;

import com.suyash.ecommerce.exception.CategoryNotFoundException;
import com.suyash.ecommerce.model.Category;
import com.suyash.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private CategoryService categoryService;

    // returns admin dashboard
    @GetMapping()
    public String adminHome() {
        return "adminHome";
    }

    // returns category page
    @GetMapping("/categories")
    public String getCategories(Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
        return "categories";
    }

    // returns add category page
    @GetMapping("/categories/add")
    public String getCategoriesAdd(Model model) {
        model.addAttribute("category", new Category());
        return "categoriesAdd";
    }

    // add category
    @PostMapping("/categories/add")
    public String postCategoriesAdd(@ModelAttribute("category") Category category) {
        categoryService.addCategory(category);
        return "redirect:/admin/categories";
    }

    // delete category by id
    @GetMapping("/categories/delete/{id}")
    public String deleteCategory(@PathVariable("id") Long id) {
        categoryService.deleteCategoryById(id);
        return "redirect:/admin/categories";
    }

    // update category by id
    @GetMapping("/categories/update/{id}")
    public String updateCategory(@PathVariable("id") Long id, Model model) throws CategoryNotFoundException {
        Optional<Category> category = categoryService.getCategoryById(id);
        if (category.isPresent()) {
            model.addAttribute("category", category.get());
            return "categoriesAdd";
        } else {
            throw new CategoryNotFoundException("Category not found");
        }
    }

}
