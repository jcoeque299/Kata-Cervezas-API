package com.example.KataCervezas.model;


//Los imports tienen que ser de Java Persistence, no de org.springframework
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Table(name="beers") //Nombre de la tabla en la base de datos (beers). Permite que el nombre de la clase y el nombre de la tabla sean distintos
@Entity //Marca que es una tabla en la base de datos, para que se maneje como tal
public class Beer{
    @Id
    @Getter @Setter
    Integer id;
    @Getter @Setter
    Integer brewery_id;
    @Getter @Setter
    String name;
    @Getter @Setter
    Integer cat_id;
    @Getter @Setter
    Integer style_id;
    @Getter @Setter
    Float abv;
    @Getter @Setter
    Float ibu;
    @Getter @Setter
    Float srm;
    @Getter @Setter
    Float upc;
    @Getter @Setter
    String filepath;
    @Getter @Setter
    String descript;
    @Getter @Setter
    Integer add_user;
    @Getter @Setter
    LocalDateTime last_mod;

    public Beer(){}
    public Beer(Integer id, Integer brewery_id, String name, Integer cat_id, Integer style_id, Float abv, Float ibu, Float srm, Float upc, String filepath, String descript, Integer add_user, LocalDateTime last_mod) {
        this.id = id;
        this.brewery_id = brewery_id;
        this.name = name;
        this.cat_id = cat_id;
        this.style_id = style_id;
        this.abv = abv;
        this.ibu = ibu;
        this.srm = srm;
        this.upc = upc;
        this.filepath = filepath;
        this.descript = descript;
        this.add_user = add_user;
        this.last_mod = last_mod;
    }
}
