package com.example.KataCervezas.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;

@Table(name="styles")
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Style{
    @Id
    Integer id;
    Integer cat_id;
    @Column(name = "style_name")
    String name;
    LocalDateTime last_mod;
}
