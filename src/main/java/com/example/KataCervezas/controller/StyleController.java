package com.example.KataCervezas.controller;

import com.example.KataCervezas.model.Style;
import com.example.KataCervezas.repository.StyleRepository;
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
public class StyleController {

    private final StyleRepository styleRepository;

    public StyleController(StyleRepository styleRepository) {
        this.styleRepository = styleRepository;
    }

    @GetMapping("/styles/")
    public List<Style> findAll() {
        return styleRepository.findAll();
    }

    @GetMapping("/styles")
    public Page<Style> findAllAndPage(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "5") Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return styleRepository.findAll(pageRequest);
    }

    @GetMapping("/style/{id}")
    public Optional<Style> findById(@PathVariable Integer id) {
        if(!styleRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found.");
        }
        return styleRepository.findById(id);
    }
}
