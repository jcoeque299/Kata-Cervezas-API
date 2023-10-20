package com.example.KataCervezas.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Table(name="styles")
@Entity
public class Style{
    @Id
    Integer id;
    Integer cat_id;
    @Column(name = "style_name")
    String name;
    LocalDateTime last_mod;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCat_id() {
        return cat_id;
    }

    public void setCat_id(Integer cat_id) {
        this.cat_id = cat_id;
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

    public Style(){}
    public Style(Integer id, Integer cat_id, String name, LocalDateTime last_mod) {
        this.id = id;
        this.cat_id = cat_id;
        this.name = name;
        this.last_mod = last_mod;
    }
}
