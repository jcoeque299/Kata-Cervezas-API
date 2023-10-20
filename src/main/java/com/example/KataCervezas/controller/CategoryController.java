package com.example.KataCervezas.controller;

import com.example.KataCervezas.model.Category;
import com.example.KataCervezas.repository.CategoryRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CategoryController {

    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/categories")
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @GetMapping("/categorie/{id}")
    public Optional<Category> findById(@PathVariable Integer id) {
        return categoryRepository.findById(id);
    }
}
