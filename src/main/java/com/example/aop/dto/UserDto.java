package com.example.aop.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class UserDto {

    private String firstName;
    private String lastName;
    private String email;
    List<ReviewDto> reviews;
    private AddressDto address;

}
