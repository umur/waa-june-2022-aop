package com.example.demo.service;

import com.example.demo.dto.CategoryDto;

import java.util.List;


public interface CategoryService {
  List<CategoryDto> findAllCategory();

  void createCategory(CategoryDto categoryDto);

  void delete(int id);

  void update(int id, CategoryDto categoryDto);
}
