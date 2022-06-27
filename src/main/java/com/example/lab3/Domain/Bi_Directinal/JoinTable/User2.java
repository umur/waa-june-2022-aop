package com.example.lab3.Domain.Bi_Directinal.JoinTable;

import com.example.lab3.Domain.Uni_Directinal.JoinTable.Address;
import com.example.lab3.Domain.Uni_Directinal.JoinTable.Review;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User2 {
    @Id
    @GeneratedValue
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    @OneToOne
    private Address2 address2;
    @OneToMany
    private List<Review2> reviews2;
}
