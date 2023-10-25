package com.example.KataCervezas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;

@Table(name="breweries")
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
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
}
