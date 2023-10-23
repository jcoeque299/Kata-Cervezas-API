package com.example.KataCervezas.repository;

import com.example.KataCervezas.model.Beer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface BeerRepository extends ListCrudRepository<Beer,Integer>, PagingAndSortingRepository<Beer,Integer> {
}
