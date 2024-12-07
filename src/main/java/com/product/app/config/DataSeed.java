package com.product.app.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.product.app.model.Category;
import com.product.app.model.Product;
import com.product.app.repository.CategoryRepository;
import com.product.app.repository.ProductRepository;


@Component
public class DataSeed implements CommandLineRunner{

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public DataSeed(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        productRepository.deleteAll();
        categoryRepository.deleteAll();

        // create categories
        Category electronics = new Category();
        electronics.setName("Electronics");

        Category clothing = new Category();
        clothing.setName("Clothing");
        Category home = new Category();
        home.setName("Home");

      categoryRepository.saveAll(Arrays.asList(electronics,home,clothing));

        Product phone = new Product();
        phone.setName("Smart Phone");
        phone.setDescription("Latest model smart phone with amazing features");
        phone.setImageUrl("https://placehold.co/600x400");
        phone.setPrice(699.99);
        phone.setCategory(electronics);

        Product laptop = new Product();
        laptop.setName("Laptop");
        laptop.setDescription("High performance laptop for work and play");
        laptop.setImageUrl("https://placehold.co/600x400");
        laptop.setPrice(1199.99);
        laptop.setCategory(electronics);

        Product jacket = new Product();
        jacket.setName("Jacket");
        jacket.setDescription("Warm and cool");
        jacket.setImageUrl("https://placehold.co/600x400");
        jacket.setPrice(299.99);
        jacket.setCategory(clothing);

        Product blender = new Product();
        blender.setName("Blender");
        blender.setDescription("High speed blender for smoothies and more..");
        blender.setImageUrl("https://placehold.co/600x400");
        blender.setPrice(499.99);
        blender.setCategory(home);

        productRepository.saveAll(Arrays.asList(phone,laptop,blender,jacket));
    }
    
}
