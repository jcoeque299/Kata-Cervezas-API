package com.example.KataCervezas.controller;

import com.example.KataCervezas.model.Style;
import com.example.KataCervezas.repository.StyleRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StyleController {

    private final StyleRepository styleRepository;

    public StyleController(StyleRepository styleRepository) {
        this.styleRepository = styleRepository;
    }

    @GetMapping("/styles")
    public List<Style> findAll() {
        return styleRepository.findAll();
    }

    @GetMapping("/style/{id}")
    public Optional<Style> findById(@PathVariable Integer id) {
        return styleRepository.findById(id);
    }
}
