package miu.edu.bimapping.controller;

import miu.edu.bimapping.dto.AddressDto;
import miu.edu.bimapping.entity.Address;
import miu.edu.bimapping.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/addresses")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping
    public Collection<AddressDto> findAll(){
        return addressService.getAllAddress();
    }
    @PostMapping
    public Address addAddress(@RequestBody AddressDto addressDto){
        return addressService.addAddress(addressDto);
    }

    @PutMapping("/{id}")
    public Address Update(@RequestBody AddressDto addressDto, @PathVariable Integer id){
        return addressService.updateAddress(addressDto, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        addressService.deleteAddress(id);
    }
}
