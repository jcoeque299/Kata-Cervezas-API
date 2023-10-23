package com.example.KataCervezas.controller;

import com.example.KataCervezas.model.Category;
import com.example.KataCervezas.repository.CategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin
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
        if(!categoryRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found.");
        }
        return categoryRepository.findById(id);
    }
}
