package edu.miu.springdata.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String street;
    private int zip;
    private String city;

//    @OneToOne(mappedBy = "address")
//    @JsonBackReference
//    private User user;
}
