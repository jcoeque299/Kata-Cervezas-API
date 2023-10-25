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
public class Category{
    @Id
    @Getter @Setter
    Integer id;
    @Column(name = "cat_name") //Nombre de la columna en la base de datos (cat_name). Permite que el nombre de la propiedad y el nombre de la columna sean distintos
    @Getter @Setter
    String name;
    @Getter @Setter
    LocalDateTime last_mod;

    public Category(){}
    public Category(Integer id, String name, LocalDateTime last_mod) {
        this.id = id;
        this.name = name;
        this.last_mod = last_mod;
    }
}
