package com.suyash.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @GetMapping()
    public String adminHome() {
        return "adminHome";
    }

    @GetMapping("/categories")
    public String getCategories() {
        return "categories";
    }
}
