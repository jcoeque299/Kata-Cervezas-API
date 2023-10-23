package com.example.KataCervezas.repository;

import com.example.KataCervezas.model.Style;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StyleRepository extends ListCrudRepository<Style,Integer>, PagingAndSortingRepository<Style,Integer> {

}
