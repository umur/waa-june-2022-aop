package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String email;
  private String password;
  private String firstName;
  private String lastname;
 @OneToMany
 @JoinColumn
 List<Review> reviewList = new ArrayList<>();

 @OneToOne

 Address address;
}
