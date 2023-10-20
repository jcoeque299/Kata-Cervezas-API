package com.example.KataCervezas.controller;

import com.example.KataCervezas.model.Beer;
import com.example.KataCervezas.repository.BeerRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BeerController {
    private final BeerRepository beerRepository; //Importa el repositorio
    public BeerController(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    } //Crea una instancia del repositorio al construir el controlador

    @GetMapping("/beers")
    public List<Beer> findAll() {
        return beerRepository.findAll();
    }

    @GetMapping("/beer/{id}")
    public Optional<Beer> findById(@PathVariable Integer id) {
        return beerRepository.findById(id);
    }
    //@PathVariable para que se introduzca la id del enlace en la funcion. De otra manera, dará null y tirará un error

    @PostMapping("/beer")
    public void create(@Valid @RequestBody Beer beer) {
        if(beerRepository.existsById(beer.getId())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Content already exists.");
        }
        beerRepository.save(beer);
    }

    @PutMapping("/beer/{id}")
    public void update(@Valid @RequestBody Beer beer, @PathVariable Integer id) {
        if(!beerRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found.");
        }
        beerRepository.save(beer);
    }

    @DeleteMapping("/beer/{id}")
    public void delete(@PathVariable Integer id) {
        if(!beerRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found.");
        }
        beerRepository.deleteById(id);
    }

//    @PatchMapping("/beer/{id}")
//    public void partialUpdate(@RequestBody Beer fieldsToUpdate, @PathVariable Integer id) {
//        if(!beerRepository.existsById(id)) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found.");
//        }
//        beerRepository.save(fieldsToUpdate);
//    }
}
