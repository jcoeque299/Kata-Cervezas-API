package com.example.KataCervezas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Table(name="breweries")
@Entity
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public Integer getAdd_user() {
        return add_user;
    }

    public void setAdd_user(Integer add_user) {
        this.add_user = add_user;
    }

    public LocalDateTime getLast_mod() {
        return last_mod;
    }

    public void setLast_mod(LocalDateTime last_mod) {
        this.last_mod = last_mod;
    }

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
