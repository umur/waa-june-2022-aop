package miu.edu.aopimplementation.service;

import miu.edu.aopimplementation.aspect.annotation.ExecutionTime;
import miu.edu.aopimplementation.aspect.annotation.LogMe;
import miu.edu.aopimplementation.dto.CategoryDto;
import miu.edu.aopimplementation.entity.Category;

import java.util.Collection;

public interface CategoryService {

    public Collection<CategoryDto> getAllCategory();


    public Category addCategory(CategoryDto categoryDto);


    public void deleteCategory(Integer id);


    public Category updateCategory(CategoryDto categoryDto, Integer id);
}
