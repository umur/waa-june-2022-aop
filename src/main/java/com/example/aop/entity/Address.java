package com.example.aop.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String street;
    private String zip;
    private String city;

    @OneToOne(mappedBy = "address", cascade = CascadeType.ALL)
    @JsonBackReference
    private User user;
}
