package miu.edu.aop.controller;

import miu.edu.aop.aspect.annotation.ExecutionTime;
import miu.edu.aop.aspect.annotation.LogMe;
import miu.edu.aop.dto.AddressDto;
import miu.edu.aop.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    @Autowired
    AddressService addressService;

    @GetMapping
    @LogMe
    @ExecutionTime
    public List<AddressDto> findAll() {
        return addressService.findAllAddress();
    }

    @PostMapping
    @LogMe
    @ExecutionTime
    public void create(@RequestBody AddressDto address) {
        addressService.createAddress(address);
    }

    @PutMapping("/{id}")
    @LogMe
    @ExecutionTime
    public AddressDto update(@RequestBody AddressDto address, @PathVariable int id) {
        return addressService.update(address, id);
    }

    @DeleteMapping("/{id}")
    @LogMe
    @ExecutionTime
    public void delete(@PathVariable int id) {
        addressService.delete(id);
    }

}
