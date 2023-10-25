package com.example.KataCervezas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Table(name="beers")
@Entity
@Getter @Setter
public class Beer{
    @Id
    Integer id;
    Integer brewery_id;
    String name;
    Integer cat_id;
    Integer style_id;
    Float abv;
    Float ibu;
    Float srm;
    Float upc;
    String filepath;
    String descript;
    Integer add_user;
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
