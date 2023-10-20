package com.example.KataCervezas.model;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Table(name="beers")
@Entity
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBrewery_id() {
        return brewery_id;
    }

    public void setBrewery_id(Integer brewery_id) {
        this.brewery_id = brewery_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCat_id() {
        return cat_id;
    }

    public void setCat_id(Integer cat_id) {
        this.cat_id = cat_id;
    }

    public Integer getStyle_id() {
        return style_id;
    }

    public void setStyle_id(Integer style_id) {
        this.style_id = style_id;
    }

    public Float getAbv() {
        return abv;
    }

    public void setAbv(Float abv) {
        this.abv = abv;
    }

    public Float getIbu() {
        return ibu;
    }

    public void setIbu(Float ibu) {
        this.ibu = ibu;
    }

    public Float getSrm() {
        return srm;
    }

    public void setSrm(Float srm) {
        this.srm = srm;
    }

    public Float getUpc() {
        return upc;
    }

    public void setUpc(Float upc) {
        this.upc = upc;
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
