package com.example.demo.service.implementation;

import com.example.demo.dto.AddressDto;
import com.example.demo.entity.Address;
import com.example.demo.repo.AddressRepo;
import com.example.demo.service.AddressService;
import com.example.demo.util.ListMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
  @Autowired
  ModelMapper modelMapper;
  @Autowired
  ListMapper<Address, AddressDto> listMapper;
  @Autowired
  AddressRepo addressRepo;

  @Override
  public List<AddressDto> findAllAddress() {
    List<Address> addresses = (List<Address>) addressRepo.findAll();
    List<AddressDto> addressDtos = (List<AddressDto>) listMapper.mapList(addresses, new AddressDto());
    return addressDtos;
  }

  @Override
  public void createAddress(AddressDto addressdto) {
    Address address1 = modelMapper.map(addressdto, Address.class);
    addressRepo.save(address1);
  }

  @Override
  public void delete(int id) {
    addressRepo.deleteById(id);
  }

  @Override
  public void update(int id, AddressDto addressDto) {
    Address address = modelMapper.map(addressDto, Address.class);
    addressRepo.findById(id).map(st -> {
      st.setCity(address.getCity());
      st.setStreet(address.getStreet());
      st.setZip(address.getZip());
      return addressRepo.save(st);
    });

  }
}
