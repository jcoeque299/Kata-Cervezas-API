package com.example.KataCervezas.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Table(name="styles")
@Entity
@Getter @Setter
public class Style{
    @Id
    Integer id;
    Integer cat_id;
    @Column(name = "style_name")
    String name;
    LocalDateTime last_mod;

    public Style(){}
    public Style(Integer id, Integer cat_id, String name, LocalDateTime last_mod) {
        this.id = id;
        this.cat_id = cat_id;
        this.name = name;
        this.last_mod = last_mod;
    }
}
