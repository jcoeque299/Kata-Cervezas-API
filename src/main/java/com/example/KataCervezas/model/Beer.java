package com.example.KataCervezas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;

@Table(name="beers")
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
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
}
