package com.example.lab3.Domain.Bi_Directinal.JoinColumn;

import com.example.lab3.Domain.Product;
import com.example.lab3.Domain.Uni_Directinal.JoinTable.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Review1 {
    @Id
    @GeneratedValue
    private int id;
    private String comment;
    @ManyToOne
    private User1 user1;
    @ManyToOne
    private Product product;
}
