package com.example.KataCervezas.controller;

import com.example.KataCervezas.error.BeerNotFoundException;
import com.example.KataCervezas.error.CategoryNotFoundException;
import com.example.KataCervezas.model.Category;
import com.example.KataCervezas.repository.CategoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    @GetMapping(path = "/categories", params = {"page", "size"})
    public Page<Category> findAllAndPage(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "5") Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return categoryRepository.findAll(pageRequest);
    }

    @GetMapping("/categorie/{id}")
    public Optional<Category> findById(@PathVariable Integer id) {
        categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException(id));
        return categoryRepository.findById(id);
    }
}
