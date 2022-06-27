package com.example.lab3.model.unidirectional;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data

public class ProductUni {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private double price;
    private int rating;

}
