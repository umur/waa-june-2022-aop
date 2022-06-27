package com.example.lab3.Domain.Uni_Directinal.JoinColumn;

import com.example.lab3.Domain.Uni_Directinal.JoinTable.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address3 {
    @Id
    @GeneratedValue
    private int id;
    private String street;
    private String zip;
    private String city;

}
