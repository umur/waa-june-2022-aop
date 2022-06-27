package com.example.lab3.DTO;

import com.example.lab3.model.bidirectional.UserBi;
import lombok.Data;

@Data
public class AddressDto {

    private String street;
    private String zip;
    private String city;
    private UserBi userBi;
}
