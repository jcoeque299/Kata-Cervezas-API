package com.example.KataCervezas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Table(name="categories")
@Entity
public class Category{
    @Id
    Integer id;
    @Column(name = "cat_name")
    String name;
    LocalDateTime last_mod;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getLast_mod() {
        return last_mod;
    }

    public void setLast_mod(LocalDateTime last_mod) {
        this.last_mod = last_mod;
    }

    public Category(){}
    public Category(Integer id, String name, LocalDateTime last_mod) {
        this.id = id;
        this.name = name;
        this.last_mod = last_mod;
    }
}
