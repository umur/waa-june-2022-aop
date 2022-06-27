package com.example.demo.service;

import com.example.demo.entity.Address;
import com.example.demo.repo.AddressRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepo addressRepo;
    public void save(Address address){
        addressRepo.save(address);
    }
    public Address getById(int id){
        var res= addressRepo.findById(id);
        return res.orElse(null);
    }
    public List<Address> getAll(){
        var res= addressRepo.findAll();
        List<Address> addresses= new ArrayList<>();
        res.forEach(addresses::add);
        return addresses;
    }

    public void delete(int id){
        addressRepo.deleteById(id);
    }

    public void update(int id, Address address){
        addressRepo.deleteById(id);
        addressRepo.save(address);
    }

}
