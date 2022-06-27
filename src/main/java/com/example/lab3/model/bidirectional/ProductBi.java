package com.example.lab3.model.bidirectional;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data

public class ProductBi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private double price;
    private int rating;
    @ManyToOne
    @JoinColumn
    CategoryBi categoryBi;

}
