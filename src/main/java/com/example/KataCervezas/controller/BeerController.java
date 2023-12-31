package com.example.KataCervezas.controller;

import com.example.KataCervezas.error.BeerAlreadyExistsException;
import com.example.KataCervezas.error.BeerNotFoundException;
import com.example.KataCervezas.error.BeerToOverwriteNotFoundException;
import com.example.KataCervezas.model.Beer;
import com.example.KataCervezas.repository.BeerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.lang.reflect.Field;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class BeerController {
    private final BeerRepository beerRepository;

    public BeerController(BeerRepository beerRepository, ObjectMapper objectMapper) {
        this.beerRepository = beerRepository;
    }

    @GetMapping("/beers")
    public ResponseEntity<?> findAll() {
        List<Beer> allBeers = beerRepository.findAll();
        return new ResponseEntity<>(allBeers, HttpStatus.OK);
    }


    @GetMapping(path = "/beers", params = {"page", "size"})
    public ResponseEntity<?> findAllAndPage(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "5") Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Beer> allBeersPaged = beerRepository.findAll(pageRequest);
        return new ResponseEntity<>(allBeersPaged, HttpStatus.OK);
    }

    @GetMapping("/beer/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        Beer beer = beerRepository.findById(id).orElseThrow(() -> new BeerNotFoundException(id));
        return new ResponseEntity<>(beer, HttpStatus.OK);
    }

    @PostMapping("/beer")
    public ResponseEntity<?> create(@Valid @RequestBody Beer beer) {
        HttpHeaders locationHeader = new HttpHeaders();
        locationHeader.setLocation(URI.create("/api/beer/"+beer.getId()));
        if(beerRepository.existsById(beer.getId())) {
            throw new BeerAlreadyExistsException(beer.getId());
        }
        beerRepository.save(beer);
        return new ResponseEntity<>(beer, locationHeader, HttpStatus.CREATED);
    }

    @PutMapping("/beer/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Beer beer, @PathVariable Integer id) {
        beerRepository.findById(id).orElseThrow(() -> new BeerNotFoundException(id));
        //Si no se especifica ID o se especifica la ID de la propia cerveza a modificar, y, por lo tanto, solo se actualizan los datos
        if (beer.getId() == 0 || id.equals(beer.getId())) {
            beer.setId(id);
            beerRepository.save(beer);
        }
        //Si se especifica ID, y, por lo tanto, se sobreescriben datos de una cerveza con otra, modificando o no sus datos a la vez
        else {
            beerRepository.findById(beer.getId()).orElseThrow(() -> new BeerToOverwriteNotFoundException(beer.getId()));
            beerRepository.deleteById(id);
            beerRepository.save(beer);
        }
        return new ResponseEntity<>(beer, HttpStatus.OK);
    }

    @DeleteMapping("/beer/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        beerRepository.findById(id).orElseThrow(() -> new BeerNotFoundException(id));
        beerRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/beer/{id}")
    public ResponseEntity<?> patch(@PathVariable Integer id, @RequestBody Map<String, Object> updates) {
        Beer beer = beerRepository.findById(id).orElseThrow(() -> new BeerNotFoundException(id));
        updates.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(Beer.class, key);
            field.setAccessible(true);
            ReflectionUtils.setField(field, beer, value);
        });
        beerRepository.save(beer);
        return new ResponseEntity<>(beer, HttpStatus.OK);
    }
}
