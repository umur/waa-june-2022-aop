package com.example.lab3.Dto;

import com.example.lab3.Domain.Uni_Directinal.JoinColumn.Address3;
import com.example.lab3.Domain.Uni_Directinal.JoinColumn.Review3;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private int id;
    private String firstName;
    private String lastName;
    private String email;

    private Address3 address3;

    private List<Review3> reviews3;
}
