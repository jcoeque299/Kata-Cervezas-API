package com.example.KataCervezas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;

@Table(name="categories")
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Category{
    @Id
    Integer id;
    @Column(name = "cat_name")
    String name;
    LocalDateTime last_mod;
}
