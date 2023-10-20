package com.example.KataCervezas.controller;

import com.example.KataCervezas.model.Brewerie;
import com.example.KataCervezas.repository.BrewerieRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BrewerieController {
    private final BrewerieRepository brewerieRepository;

    public BrewerieController(BrewerieRepository brewerieRepository) {
        this.brewerieRepository = brewerieRepository;
    }

    @GetMapping("/breweries")
    public List<Brewerie> findall(){
        return brewerieRepository.findAll();
    }

    @GetMapping("/brewerie/{id}")
    public Optional<Brewerie> findById(@PathVariable Integer id) {
        return brewerieRepository.findById(id);
    }
}
