package miu.edu.bimapping.service;

import miu.edu.bimapping.dto.CategoryDto;
import miu.edu.bimapping.entity.Category;

import java.util.Collection;

public interface CategoryService {
    public Collection<CategoryDto> getAllCategory();

    public Category addCategory(CategoryDto categoryDto);

    public void deleteCategory(Integer id);

    public Category updateCategory(CategoryDto categoryDto, Integer id);
}
