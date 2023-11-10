package com.example.KataCervezas.controller;

import com.example.KataCervezas.error.BeerNotFoundException;
import com.example.KataCervezas.error.CategoryNotFoundException;
import com.example.KataCervezas.model.Category;
import com.example.KataCervezas.repository.CategoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> findAll() {
        List<Category> allCategories = categoryRepository.findAll();
        return new ResponseEntity<>(allCategories, HttpStatus.OK);
    }

    @GetMapping(path = "/categories", params = {"page", "size"})
    public ResponseEntity<?> findAllAndPage(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "5") Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Category> allCategoriesPaged = categoryRepository.findAll(pageRequest);
        return new ResponseEntity<>(allCategoriesPaged, HttpStatus.OK);
    }

    @GetMapping("/categorie/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException(id));
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
}
