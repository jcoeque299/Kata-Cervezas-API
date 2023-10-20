package com.example.KataCervezas.repository;

import com.example.KataCervezas.model.Beer;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BeerRepository extends ListCrudRepository<Beer,Integer> {
    List<Beer> findAllByName(String type);
}
