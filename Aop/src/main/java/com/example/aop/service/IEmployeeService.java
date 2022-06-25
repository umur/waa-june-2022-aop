package com.example.aop.service;

import com.example.aop.dto.EmployeeDto;
import com.example.aop.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IEmployeeService {
    EmployeeDto save(EmployeeDto user);

    List<EmployeeDto> getUsers();

    EmployeeDto getById(int id);

    void deleteById(int id);

    EmployeeDto edit(int id, EmployeeDto user);
}
