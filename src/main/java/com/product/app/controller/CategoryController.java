package com.product.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.app.model.Category;
import com.product.app.service.CategoryService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/categories")
public class CategoryController {



     private final CategoryService categoryService;

     public CategoryController(CategoryService categoryService){
        this.categoryService=categoryService;
     }

     @GetMapping("/")
    public List<Category> getAllCategories(){
        List<Category> cat = categoryService.getAllCategories();
        return cat;
    }

    
}
