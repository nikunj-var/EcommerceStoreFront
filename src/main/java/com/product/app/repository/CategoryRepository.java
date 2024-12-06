package com.product.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.app.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long>{

   
}