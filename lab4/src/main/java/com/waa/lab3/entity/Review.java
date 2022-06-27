package com.waa.lab3.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;

    @ManyToOne
    private User user;

    @OneToOne
    private Product product;
}
