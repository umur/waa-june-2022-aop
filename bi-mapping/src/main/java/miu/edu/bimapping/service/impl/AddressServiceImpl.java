package miu.edu.bimapping.service.impl;


import miu.edu.bimapping.dto.AddressDto;
import miu.edu.bimapping.entity.Address;
import miu.edu.bimapping.repository.AddressRepository;
import miu.edu.bimapping.service.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public Collection<AddressDto> getAllAddress() {
        Collection<Address> address = (List<Address>) addressRepository.findAll();
        List<AddressDto> addressDto = address.stream()
                .map(st ->toDto(st))
                .collect(Collectors.toList());
        return addressDto;
    }

    @Override
    public Address addAddress(AddressDto addressDto) {
        Address address = toEntity(addressDto);
        return addressRepository.save(address) ;
    }

    @Override
    public void deleteAddress(Integer id) {
        addressRepository.deleteById(id);
    }

    @Override
    public Address updateAddress(AddressDto addressDto, Integer id) {
        Address address = toEntity(addressDto);
        addressRepository.findById(id).map(ad->{
            ad.setCity(ad.getCity());
            ad.setStreet(ad.getStreet());
            ad.setZip(ad.getZip());
            return this.addressRepository.save(ad);
        });
        return address;
    }

    public AddressDto toDto(Address address){
        AddressDto addressDto = mapper.map(address, AddressDto.class);
        return addressDto;
    }

    public Address toEntity(AddressDto addressDto){
        Address address = mapper.map(addressDto, Address.class);
        return address;
    }
}
