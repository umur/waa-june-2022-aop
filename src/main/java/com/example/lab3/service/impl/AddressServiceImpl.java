package com.example.lab3.service.impl;

import com.example.lab3.DTO.AddressDto;
import com.example.lab3.Repository.AddressRepo;
import com.example.lab3.model.bidirectional.AddressBi;
import com.example.lab3.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AddressServiceImpl implements AddressService {
    private final AddressRepo addressRepo;
    private final ModelMapper modelMapper;

    @Override
    public void save(AddressDto p) {
        addressRepo.save(modelMapper.map(p, AddressBi.class));
    }

    @Override
    public void delete(long id) {
        addressRepo.deleteById(id);
    }

    @Override
    public void update(long id, AddressDto addressDto) {
        AddressBi addressBi = modelMapper.map(addressDto, AddressBi.class);
        addressBi.setId(id);
        addressRepo.save(addressBi);
    }

    @Override
    public List<AddressDto> findAll() {
        return addressRepo.findAll().stream().map(addressBi -> modelMapper.map(addressBi, AddressDto.class)).toList();

    }
}
