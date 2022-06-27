package com.example.lab3.Domain.Uni_Directinal.JoinColumn;

import com.example.lab3.Domain.Uni_Directinal.JoinTable.Address;
import com.example.lab3.Domain.Uni_Directinal.JoinTable.Review;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User3 {
    @Id
    @GeneratedValue
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    @OneToOne
    private Address3 address3;
    @OneToMany
    @JoinColumn(name = "review_id")
    private List<Review3> reviews3;
}
