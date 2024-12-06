package com.product.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.app.model.Product;
import com.product.app.service.ProductService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;
    public ProductController(ProductService productService){
        this.productService=productService;
    }

    @GetMapping("/")
    public List<Product> getAllProduct() {
        return productService.getAllProducts();
       
    }
    
    @GetMapping("/category/{categoryId}")
    public List<Product> getMethodName(@PathVariable Long categoryId) {
        return productService.getProductByCategory(categoryId);
    }

    @PostMapping("/")
    public String addProductData(@RequestBody Product product) {
        return "productServic";
    }
    
  


    
}
