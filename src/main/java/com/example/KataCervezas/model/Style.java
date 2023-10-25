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
public class Style{
    @Id
    @Getter @Setter
    Integer id;
    @Getter @Setter
    Integer cat_id;
    @Column(name = "style_name")
    @Getter @Setter
    String name;
    @Getter @Setter
    LocalDateTime last_mod;

    public Style(){}
    public Style(Integer id, Integer cat_id, String name, LocalDateTime last_mod) {
        this.id = id;
        this.cat_id = cat_id;
        this.name = name;
        this.last_mod = last_mod;
    }
}
