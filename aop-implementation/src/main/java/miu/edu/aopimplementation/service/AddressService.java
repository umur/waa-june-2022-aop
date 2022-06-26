package miu.edu.aopimplementation.service;

import miu.edu.aopimplementation.dto.AddressDto;
import miu.edu.aopimplementation.entity.Address;

import java.util.Collection;

public interface AddressService {


    public Collection<AddressDto> getAllAddress();


    public Address addAddress(AddressDto addressDto);


    public void deleteAddress(Integer id);


    public Address updateAddress(AddressDto addressDto, Integer id);
}
