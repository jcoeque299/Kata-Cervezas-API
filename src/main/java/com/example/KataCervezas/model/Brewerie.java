package com.example.KataCervezas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Table(name="breweries")
@Entity
@Getter @Setter
public class Brewerie{
    @Id
    Integer id;
    String name;
    String address1;
    String address2;
    String city;
    String state;
    String code;
    String country;
    String phone;
    String website;
    String filepath;
    String descript;
    Integer add_user;
    LocalDateTime last_mod;

    public Brewerie(){}
    public Brewerie(Integer id, String name, String address1, String address2, String city, String state, String code, String country, String phone, String website, String filepath, String descript, Integer add_user, LocalDateTime last_mod) {
        this.id = id;
        this.name = name;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.code = code;
        this.country = country;
        this.phone = phone;
        this.website = website;
        this.filepath = filepath;
        this.descript = descript;
        this.add_user = add_user;
        this.last_mod = last_mod;
    }
}
