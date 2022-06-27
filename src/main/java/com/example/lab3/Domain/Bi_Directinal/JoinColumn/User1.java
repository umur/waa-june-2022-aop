package com.example.lab3.Domain.Bi_Directinal.JoinColumn;

import com.example.lab3.Domain.Uni_Directinal.JoinTable.Address;
import com.example.lab3.Domain.Uni_Directinal.JoinTable.Review;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User1 {
    @Id
    @GeneratedValue
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    @OneToOne
    private Address1 address1;
    @OneToMany(mappedBy = "user1")
    private List<Review1> reviews1;
}
