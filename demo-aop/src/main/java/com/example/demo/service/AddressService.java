package com.example.demo.service;

import com.example.demo.dto.AddressDto;

import java.util.List;


public interface AddressService {
  List<AddressDto> findAllAddress();

  void createAddress(AddressDto address);

  void delete(int id);

  void update(int id, AddressDto addressDto);


}
