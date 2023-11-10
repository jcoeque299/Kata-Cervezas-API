package com.example.KataCervezas.controller;

import com.example.KataCervezas.error.BeerNotFoundException;
import com.example.KataCervezas.error.BrewerieNotFoundException;
import com.example.KataCervezas.model.Brewerie;
import com.example.KataCervezas.repository.BrewerieRepository;
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
public class BrewerieController {
    private final BrewerieRepository brewerieRepository;

    public BrewerieController(BrewerieRepository brewerieRepository) {
        this.brewerieRepository = brewerieRepository;
    }

    @GetMapping("/breweries")
    public ResponseEntity<?> findAll(){
        List<Brewerie> allBreweries = brewerieRepository.findAll();
        return new ResponseEntity<>(allBreweries, HttpStatus.OK);
    }

    @GetMapping(path = "/breweries", params = {"page", "size"})
    public ResponseEntity<?> findAllAndPage(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "5") Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Brewerie> allBreweriesPaged = brewerieRepository.findAll(pageRequest);
        return new ResponseEntity<>(allBreweriesPaged, HttpStatus.OK);
    }

    @GetMapping("/brewerie/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        Brewerie brewerie = brewerieRepository.findById(id).orElseThrow(() -> new BrewerieNotFoundException(id));
        return new ResponseEntity<>(brewerie, HttpStatus.OK);
    }
}
