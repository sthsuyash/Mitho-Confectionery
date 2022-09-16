package com.suyash.ecommerce.controller;

import com.suyash.ecommerce.service.CategoryService;
import com.suyash.ecommerce.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ItemService itemService;

    // returns home page
    @GetMapping({"/", "/home"})
    public String home(Model model) {
        return "index";
    }

    // returns shop page
    @GetMapping("/shop")
    public String shop(Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("items", itemService.getAllItems());
        return "shop";
    }

    // shop by category
    @GetMapping("/shop/categories/{id}")
    public String shopByCategory(Model model, @PathVariable("id") Long id) {
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("items", itemService.getAllItemsByCategory(id));

        return "shop";
    }

    // returns view product page
    @GetMapping("/shop/viewItem/{id}")
    public String viewItem(Model model, @PathVariable("id") Long id) {
        model.addAttribute("item", itemService.getItemById(id).get());

        return "viewItem";
    }

}
