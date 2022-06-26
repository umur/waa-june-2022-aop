package com.lab5.Spring.aop.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int rating;
    private double price;

    @JsonIgnoreProperties("products")
    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;
}
