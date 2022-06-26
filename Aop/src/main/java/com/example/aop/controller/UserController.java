package com.example.aop.controller;

import com.example.aop.aspect.annotation.ExecutionTime;
import com.example.aop.dto.EmployeeDto;
import com.example.aop.entity.Employee;
import com.example.aop.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private IEmployeeService userService;

    @Autowired
    public UserController(IEmployeeService userService)
    {
        this.userService = userService;
    }

    @PostMapping()
    public EmployeeDto save(@RequestBody EmployeeDto user) {
        return userService.save(user);
    }

    @PutMapping("/{id}")
    public EmployeeDto edit(@PathVariable int id, @RequestBody EmployeeDto user) {
        return userService.edit(id, user);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        userService.deleteById(id);
        return "Delete";
    }

    @GetMapping()
    @ExecutionTime
    public List<EmployeeDto> getUsers() {

        System.out.println("Inside -------");
        return userService.getUsers();
    }

}
