package com.example.lab3.Domain.Bi_Directinal.JoinTable;

import com.example.lab3.Domain.Uni_Directinal.JoinTable.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Address2 {
    @Id
    @GeneratedValue
    private int id;
    private String street;
    private String zip;
    private String city;
    @OneToOne(mappedBy = "address2")
    private User2 user2;
}
