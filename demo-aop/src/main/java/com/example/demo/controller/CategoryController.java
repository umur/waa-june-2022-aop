package com.example.demo.controller;

import com.example.demo.aspect.annotations.ExecutionTime;
import com.example.demo.aspect.annotations.LogMe;
import com.example.demo.dto.CategoryDto;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")

public class CategoryController {
  @Autowired
  CategoryService categoryService;

  @GetMapping
  @LogMe
  @ExecutionTime
  public List<CategoryDto> findAllCategory() {

    return categoryService.findAllCategory();
  }

  @PostMapping
  @LogMe
  @ExecutionTime
  public void createCategory(@RequestBody CategoryDto dto) {
    categoryService.createCategory(dto);
  }

  @DeleteMapping("/{id}")
  @LogMe
  @ExecutionTime
  public void deleteCategory(@PathVariable int id) {
    categoryService.delete(id);
  }

  @PutMapping("/{id}")
  @LogMe
  @ExecutionTime
  public void update(@RequestBody @PathVariable int id, CategoryDto categoryDto) {

    categoryService.update(id, categoryDto);
  }
}
