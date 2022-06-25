package com.example.aop.service.impl;

import com.example.aop.dto.EmployeeDto;
import com.example.aop.entity.Employee;
import com.example.aop.repository.IEmployeeRepo;
import com.example.aop.service.IEmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private IEmployeeRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public EmployeeDto save(EmployeeDto user) {
        Employee employee = modelMapper.map(user, Employee.class);
        userRepo.save(employee);
        return user;
    }

    @Override
    public List<EmployeeDto> getUsers() {
        return userRepo.findAll().stream().map(x -> modelMapper.map(x, EmployeeDto.class)).toList();
    }

    @Override
    public EmployeeDto getById(int id) {
        return userRepo.findById(id).stream().map(x -> modelMapper.map(x, EmployeeDto.class)).findAny().get();
    }

    @Override
    public void deleteById(int id) {
        userRepo.deleteById(id);
    }

    @Override
    public EmployeeDto edit(int id, EmployeeDto user) {
        Employee employee = modelMapper.map(user, Employee.class);
        employee.setId(id);
        userRepo.save(employee);
        return user;
    }
}
