package com.example.aop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Review {
    @Id @GeneratedValue
    private int id;
    @Lob
    private String comment;
}
