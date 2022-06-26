package com.example.aop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Address {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String street;
    private int zip;
    private String city;
}
