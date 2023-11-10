package com.example.KataCervezas.controller;

import com.example.KataCervezas.error.BeerNotFoundException;
import com.example.KataCervezas.error.StyleNotFoundException;
import com.example.KataCervezas.model.Style;
import com.example.KataCervezas.repository.StyleRepository;
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
public class StyleController {

    private final StyleRepository styleRepository;

    public StyleController(StyleRepository styleRepository) {
        this.styleRepository = styleRepository;
    }

    @GetMapping("/styles")
    public ResponseEntity<?> findAll() {
        List<Style> allStyles = styleRepository.findAll();
        return new ResponseEntity<>(allStyles, HttpStatus.OK);
    }

    @GetMapping(path = "/styles", params = {"page", "size"})
    public ResponseEntity<?> findAllAndPage(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "5") Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Style> allStylesPaged = styleRepository.findAll(pageRequest);
        return new ResponseEntity<>(allStylesPaged, HttpStatus.OK);
    }

    @GetMapping("/style/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        Style style = styleRepository.findById(id).orElseThrow(() -> new StyleNotFoundException(id));
        return new ResponseEntity<>(style, HttpStatus.OK);
    }
}
