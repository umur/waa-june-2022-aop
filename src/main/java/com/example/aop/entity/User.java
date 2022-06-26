package com.example.aop.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue
    private int Id;
    private String firstName;
    private String lastName;
    private String email;
    @JsonIgnore
    private String password;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonBackReference
    List<Review> reviews;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    private Address address;

}
