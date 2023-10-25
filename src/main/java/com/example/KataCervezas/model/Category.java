package com.example.KataCervezas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Table(name="categories")
@Entity
@Getter @Setter
public class Category{
    @Id
    Integer id;
    @Column(name = "cat_name")
    String name;
    LocalDateTime last_mod;

    public Category(){}
    public Category(Integer id, String name, LocalDateTime last_mod) {
        this.id = id;
        this.name = name;
        this.last_mod = last_mod;
    }
}
