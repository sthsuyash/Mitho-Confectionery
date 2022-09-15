package com.suyash.ecommerce.controller;

import com.suyash.ecommerce.dto.ItemDTO;
import com.suyash.ecommerce.exception.CategoryNotFoundException;
import com.suyash.ecommerce.model.Category;
import com.suyash.ecommerce.model.Item;
import com.suyash.ecommerce.service.CategoryService;
import com.suyash.ecommerce.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {

    public static String uploadDirectory = System.getProperty("user.dir") + "/src/main/resources/static/itemImages";

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ItemService itemService;

    // returns admin dashboard
    @GetMapping()
    public String adminHome() {
        return "adminHome";
    }

    /**
     * category section
     **/

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

    /**
     * items section
     **/

    // returns items page
    @GetMapping("/items")
    public String getItems(Model model) {
        model.addAttribute("items", itemService.getAllItems());
        return "items";
    }

    // returns add product page
    @GetMapping("/items/add")
    public String getItemsAdd(Model model) {
        model.addAttribute("itemDTO", new ItemDTO());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "itemsAdd";
    }

    // add product
    @PostMapping("/items/add")
    public String postItemsAdd(@ModelAttribute("itemDTO") ItemDTO itemDTO,
                               @RequestParam("itemImage") MultipartFile file,
                               @RequestParam("imageUrl") String imageUrl)
            throws IOException {

        Item item = new Item();

        item.setId(itemDTO.getId());
        item.setName(itemDTO.getName());
        item.setCategory(categoryService.getCategoryById(itemDTO.getCategoryId()).get());
        item.setPrice(itemDTO.getPrice());
        item.setWeight(itemDTO.getWeight());
        item.setDescription(itemDTO.getDescription());

        String imageUUID;
        if (!file.isEmpty()) {
            imageUUID = file.getOriginalFilename();
            Path fileNameAndPath = Path.of(uploadDirectory, imageUUID);
            Files.write(fileNameAndPath, file.getBytes());
        } else {
            imageUUID = imageUrl;
        }
        item.setImageName(imageUUID);

        itemService.addItem(item);

        return "redirect:/admin/items";
    }


}
