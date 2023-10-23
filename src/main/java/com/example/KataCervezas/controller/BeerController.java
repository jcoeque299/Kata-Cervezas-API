package com.example.KataCervezas.controller;

import com.example.KataCervezas.model.Beer;
import com.example.KataCervezas.repository.BeerRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin //Permite realizar requests desde un frontend JavaScript. Se debería de configurar la anotación para que el acceso sea controlado
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
        if(!beerRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found.");
        }
        return beerRepository.findById(id);
    }
    //@PathVariable para que se introduzca la id del enlace en la funcion. De otra manera, dará null y tirará un error

    @PostMapping("/beer")
    public ResponseEntity<String> create(@Valid @RequestBody Beer beer) {
        HttpHeaders locationHeader = new HttpHeaders();
        locationHeader.setLocation(URI.create("/api/beer/"+beer.getId()));
        if(beerRepository.existsById(beer.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Content already exists.");
        }
        beerRepository.save(beer);
        return new ResponseEntity<>(locationHeader, HttpStatus.CREATED);
    }

    @PutMapping("/beer/{id}")
    public ResponseEntity<String> update(@Valid @RequestBody Beer beer, @PathVariable Integer id) {
        if(!beerRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found.");
        }
        beerRepository.save(beer);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/beer/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        if(!beerRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found.");
        }
        beerRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
