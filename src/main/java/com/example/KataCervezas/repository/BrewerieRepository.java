package com.example.KataCervezas.repository;

import com.example.KataCervezas.model.Brewerie;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrewerieRepository extends ListCrudRepository<Brewerie,Integer>, PagingAndSortingRepository<Brewerie,Integer> {
}
