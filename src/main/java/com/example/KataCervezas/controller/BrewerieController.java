package com.example.KataCervezas.controller;

import com.example.KataCervezas.error.BeerNotFoundException;
import com.example.KataCervezas.error.BrewerieNotFoundException;
import com.example.KataCervezas.model.Brewerie;
import com.example.KataCervezas.repository.BrewerieRepository;
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
public class BrewerieController {
    private final BrewerieRepository brewerieRepository;

    public BrewerieController(BrewerieRepository brewerieRepository) {
        this.brewerieRepository = brewerieRepository;
    }

    @GetMapping("/breweries")
    public List<Brewerie> findall(){
        return brewerieRepository.findAll();
    }

    @GetMapping(path = "/breweries", params = {"page", "size"})
    public Page<Brewerie> findAllAndPage(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "5") Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return brewerieRepository.findAll(pageRequest);
    }

    @GetMapping("/brewerie/{id}")
    public Optional<Brewerie> findById(@PathVariable Integer id) {
        brewerieRepository.findById(id).orElseThrow(() -> new BrewerieNotFoundException(id));
        return brewerieRepository.findById(id);
    }
}
