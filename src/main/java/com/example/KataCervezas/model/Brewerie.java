package com.example.KataCervezas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Table(name="breweries")
@Entity
public class Brewerie{
    @Id
    @Getter @Setter
    Integer id;
    @Getter @Setter
    String name;
    @Getter @Setter
    String address1;
    @Getter @Setter
    String address2;
    @Getter @Setter
    String city;
    @Getter @Setter
    String state;
    @Getter @Setter
    String code;
    @Getter @Setter
    String country;
    @Getter @Setter
    String phone;
    @Getter @Setter
    String website;
    @Getter @Setter
    String filepath;
    @Getter @Setter
    String descript;
    @Getter @Setter
    Integer add_user;
    @Getter @Setter
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
