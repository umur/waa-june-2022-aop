package com.example.aop.service;

import com.example.aop.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IEmployeeService {
    Employee save(Employee user);

    List<Employee> getUsers();

    Employee getById(int id);

    void deleteById(int id);

    Employee edit(int id, Employee user);
}
