package com.lab5.Spring.aop.service;

import com.lab5.Spring.aop.dto.AddCategoryDto;
import com.lab5.Spring.aop.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    List<CategoryDto> findAll();

    AddCategoryDto create(AddCategoryDto AddcategoryDto);
}
