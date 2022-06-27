package com.example.lab3.model.bidirectional;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data

public class AddressBi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String street;
    private String zip;
    private String city;
    @OneToOne(mappedBy = "addressBi")
    UserBi userBi;

}
