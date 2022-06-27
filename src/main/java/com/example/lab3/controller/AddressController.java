package com.example.lab3.controller;

import com.example.lab3.DTO.AddressDto;
import com.example.lab3.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/address")
public class AddressController {
    private final AddressService addressService;

    @GetMapping
    public List<AddressDto> findAll() {
        return addressService.findAll();
    }

    @PostMapping
    public void create(@RequestBody AddressDto addressDto) {
        addressService.save(addressDto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable long id, @RequestBody AddressDto addressDto) {
        addressService.update(id, addressDto);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable long id) {
        addressService.delete(id);
    }



}
