package com.example.aop.controller;

import com.example.aop.aspect.annotation.ExecutionTime;
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
    public Employee save(@RequestBody Employee user) {
        return userService.save(user);
    }

    @PutMapping("/{id}")
    public Employee edit(@PathVariable int id, @RequestBody Employee user) {
        return userService.edit(id, user);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        userService.deleteById(id);
        return "Delete";
    }

    @GetMapping()
    @ExecutionTime
    public List<Employee> getUsers() {

        System.out.println("INside -------");
        return userService.getUsers();
    }

}
