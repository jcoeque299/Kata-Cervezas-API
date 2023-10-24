package com.example.KataCervezas.controller;

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
@CrossOrigin //Permite realizar requests desde un frontend JavaScript. Se debería de configurar la anotación para que el acceso sea controlado
public class BeerController {
    //Importa el repositorio
    private final BeerRepository beerRepository;

    //Crea una instancia del repositorio al construir el controlador
    public BeerController(BeerRepository beerRepository, ObjectMapper objectMapper) {
        this.beerRepository = beerRepository;
    }

    @GetMapping("/beers")
    public List<Beer> findAll() {
        return beerRepository.findAll();
    }

    //Es imposible, o al menos no he sido capaz de conseguir que una HEAD request devuelva un body. Si este codigo
    //exacto lo mapeo a un HEAD, no funciona. Asi que las busquedas paginadas las he asignado a un GET
    @GetMapping(path = "/beers", params = {"page", "size"})
    public Page<Beer> findAllAndPage(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "5") Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return beerRepository.findAll(pageRequest);
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

    @PatchMapping("/beer/{id}")
    public ResponseEntity<String> patch(@PathVariable Integer id, @RequestBody Map<String, Object> updates) {
        if(!beerRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found.");
        }
        Beer beer = beerRepository.findById(id).orElseThrow();
        //Extrae los campos introducidos en el body, y los actualiza uno a uno en la cerveza elegida para después guardar esos cambios
        updates.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(Beer.class, key);
            field.setAccessible(true); //Los atributos son private en la clase. Esto los hace accesibles
            ReflectionUtils.setField(field, beer, value);
        });
        beerRepository.save(beer);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
