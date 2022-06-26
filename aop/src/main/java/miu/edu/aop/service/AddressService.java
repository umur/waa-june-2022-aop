package miu.edu.aop.service;

import miu.edu.aop.dto.AddressDto;

import java.util.List;

public interface AddressService {
    List<AddressDto> findAllAddress();

    void createAddress(AddressDto address);

    void delete(int id);

    AddressDto update(AddressDto addressDto, int id);


}
