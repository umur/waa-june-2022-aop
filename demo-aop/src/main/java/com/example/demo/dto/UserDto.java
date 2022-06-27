package com.example.demo.dto;

import com.example.demo.entity.Address;
import com.example.demo.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
  private int id;
  private String email;
  private String password;
  private String firstName;
  private String lastname;

  List<Review> reviewList = new ArrayList<>();

  Address address;
}
