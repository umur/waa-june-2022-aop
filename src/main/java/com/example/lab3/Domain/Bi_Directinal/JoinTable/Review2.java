package com.example.lab3.Domain.Bi_Directinal.JoinTable;

import com.example.lab3.Domain.Uni_Directinal.JoinTable.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review2 {
    @Id
    @GeneratedValue
    private int id;
    private String comment;
    @ManyToOne
    private User2 user2;
}
