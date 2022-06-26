package com.lab5.Spring.aop.controller;

import com.lab5.Spring.aop.aspect.annotation.ExecutionTime;
import com.lab5.Spring.aop.dto.AddCategoryDto;
import com.lab5.Spring.aop.dto.CategoryDto;
import com.lab5.Spring.aop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

//    Used @Pointcut within service package, if you want to check you can remove it and run it!
//    @ExecutionTime
    @GetMapping
    public ResponseEntity<List<CategoryDto>> findAll() {
        return ResponseEntity.ok(categoryService.findAll());
    }

//    Used @Pointcut within service package, if you want to check you can remove it and run it!
//    @ExecutionTime
    @PostMapping
    public ResponseEntity<?> create(@RequestBody AddCategoryDto addCategoryDto) {
        return ResponseEntity.ok(categoryService.create(addCategoryDto));
    }
}
