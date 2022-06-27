package com.example.lab3.model.unidirectional;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data

public class UserUni {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;

    @OneToMany
    @JoinColumn(name = "id_userUni")
    List<ReviewUni> reviewUni;
    @OneToOne
    @JoinColumn(name = "id_address")
    AddressUni addressUni;


}
