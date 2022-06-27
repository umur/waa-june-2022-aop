package com.example.lab3.model.bidirectional;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class UserBi {
    @OneToMany(mappedBy = "userBi", cascade = CascadeType.PERSIST)
    List<ReviewBi> reviewBis;
    @OneToOne(cascade = CascadeType.PERSIST)
    AddressBi addressBi;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;


}
