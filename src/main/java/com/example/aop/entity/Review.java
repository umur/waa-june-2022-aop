package com.example.aop.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String comment;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    User user;


}
