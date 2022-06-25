package com.example.aop.service.impl;

import com.example.aop.entity.Employee;
import com.example.aop.repository.IEmployeeRepo;
import com.example.aop.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private IEmployeeRepo userRepo;

    @Override
    public Employee save(Employee user) {
        return userRepo.save(user);
    }

    @Override
    public List<Employee> getUsers() {
        return userRepo.findAll();
    }

    @Override
    public Employee getById(int id) {
        return userRepo.findById(id).get();
    }

    @Override
    public void deleteById(int id) {
        userRepo.deleteById(id);
    }

    @Override
    public Employee edit(int id, Employee user) {
        user.setId(id);
        return userRepo.save(user);
    }
}
