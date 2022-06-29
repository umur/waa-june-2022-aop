package com.example.lab5.bidirectional.controller;

import com.example.lab5.bidirectional.entity.Address;
import com.example.lab5.bidirectional.service.AddressService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/save")
    public void createAddress(@RequestBody Address address){
        addressService.save(address);
    }



}
