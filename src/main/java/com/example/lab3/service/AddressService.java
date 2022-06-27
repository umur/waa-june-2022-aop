package com.example.lab3.service;

import com.example.lab3.DTO.AddressDto;

import java.util.List;

public interface AddressService {
    void save(AddressDto p);

    void delete(long id);

    void update(long id, AddressDto addressDto);


    List<AddressDto> findAll();

}
