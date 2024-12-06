package com.product.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.product.app.model.Product;
import com.product.app.repository.ProductRepository;

@Service
public class ProductService {
    
    private ProductRepository productRepository;

    public ProductService (ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
       return productRepository.findAll();
    }

    public List<Product> getProductByCategory(Long categoryId){
        return productRepository.findByCategoryId(categoryId);
    }
}
