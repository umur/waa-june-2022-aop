package com.lab5.Spring.aop.service.impl;

import com.lab5.Spring.aop.dto.AddCategoryDto;
import com.lab5.Spring.aop.dto.CategoryDto;
import com.lab5.Spring.aop.model.Category;
import com.lab5.Spring.aop.repo.CategoryRepo;
import com.lab5.Spring.aop.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<CategoryDto> findAll() {
        List<CategoryDto> categoryDtos = new ArrayList<>();
        categoryRepo.findAll().forEach(c-> {
            categoryDtos.add(convertToDto(c));
        });
        return categoryDtos;
    }

    @Override
    public AddCategoryDto create(AddCategoryDto AddcategoryDto) {
        Category category = categoryRepo.save(convertToEntity(AddcategoryDto));
        return AddcategoryDto;
    }

    private CategoryDto convertToDto(Category category) {
        CategoryDto categoryDto = modelMapper.map(category, CategoryDto.class);
        return categoryDto;
    }

    private Category convertToEntity(AddCategoryDto addCategoryDto) {
        Category category = modelMapper.map(addCategoryDto, Category.class);
        return category;
    }
}
