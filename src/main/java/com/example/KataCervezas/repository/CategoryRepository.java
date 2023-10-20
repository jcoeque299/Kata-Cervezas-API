package com.example.KataCervezas.repository;

import com.example.KataCervezas.model.Category;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends ListCrudRepository<Category,Integer> {
    List<Category> findAllByName(String type);
}
