package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String street;
    private int zip;
    private String city;

    @OneToOne(mappedBy = "address")//prevent having user FK inside Address table
    private User user;


}
