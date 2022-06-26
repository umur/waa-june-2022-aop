package miu.edu.aop.service;

import miu.edu.aop.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> findAll();

    void createCategory(CategoryDto categoryDto);

    void delete(int id);

    CategoryDto update(CategoryDto category, int id);
}
