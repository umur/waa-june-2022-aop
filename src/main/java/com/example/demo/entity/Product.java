package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private double price;
    private int rating;


    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<Review> reviews;

}
