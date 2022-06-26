package miu.edu.aopimplementation.controller;

import miu.edu.aopimplementation.aspect.annotation.ExecutionTime;
import miu.edu.aopimplementation.aspect.annotation.LogMe;
import miu.edu.aopimplementation.dto.AddressDto;
import miu.edu.aopimplementation.entity.Address;
import miu.edu.aopimplementation.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/addresses")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @ExecutionTime
    @LogMe
    @GetMapping
    public Collection<AddressDto> findAll(){
        return addressService.getAllAddress();
    }

    @ExecutionTime
    @LogMe
    @PostMapping
    public Address addAddress(@RequestBody AddressDto addressDto){
        return addressService.addAddress(addressDto);
    }

    @ExecutionTime
    @LogMe
    @PutMapping("/{id}")
    public Address Update(@RequestBody AddressDto addressDto, @PathVariable Integer id){
        return addressService.updateAddress(addressDto, id);
    }

    @ExecutionTime
    @LogMe
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        addressService.deleteAddress(id);
    }
}
