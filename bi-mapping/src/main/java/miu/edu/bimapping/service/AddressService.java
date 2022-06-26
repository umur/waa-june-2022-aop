package miu.edu.bimapping.service;

import miu.edu.bimapping.dto.AddressDto;
import miu.edu.bimapping.entity.Address;

import java.util.Collection;

public interface AddressService {
    public Collection<AddressDto> getAllAddress();

    public Address addAddress(AddressDto addressDto);

    public void deleteAddress(Integer id);

    public Address updateAddress(AddressDto addressDto, Integer id);
}
