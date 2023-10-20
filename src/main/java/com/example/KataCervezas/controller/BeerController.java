package com.example.KataCervezas.controller;

import com.example.KataCervezas.model.Beer;
import com.example.KataCervezas.repository.BeerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BeerController {
    private final BeerRepository beerRepository;
    public BeerController(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @GetMapping("/beers")
    public List<Beer> findAll() {
        return beerRepository.findAll();
    }

    @GetMapping("/beer/{id}")
    public Optional<Beer> findById(@PathVariable Integer id) {
        return beerRepository.findById(id);
    }
    //@PathVariable para que se introduzca la id en la busqueda
}
