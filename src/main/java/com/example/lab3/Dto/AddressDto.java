package com.example.lab3.Dto;

import com.example.lab3.Domain.Uni_Directinal.JoinTable.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {
    private int id;
    private String street;
    private String zip;
    private String city;
    private User user;
}
