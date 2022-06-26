package com.example.demo.service.implementation;

import com.example.demo.dto.CategoryDto;
import com.example.demo.entity.Category;
import com.example.demo.repo.CategoryRepo;
import com.example.demo.service.CategoryService;
import com.example.demo.util.ListMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CatogoryServiceImpl  implements CategoryService {
  @Autowired
  ModelMapper modelMapper;
  @Autowired
  ListMapper<Category, CategoryDto> listMapper;
  @Autowired
  CategoryRepo categoryRepo;

  @Override
  public List<CategoryDto> findAllCategory() {
    List<Category> categories = categoryRepo.findAll();
    List<CategoryDto> categoryDto = (List<CategoryDto>) listMapper.mapList(categories, new CategoryDto());
    return categoryDto;
  }

  @Override
  public void createCategory(CategoryDto categoryDto) {
    Category category = modelMapper.map(categoryDto, Category.class);
    categoryRepo.save(category);
  }

  @Override
  public void delete(int id) {
    categoryRepo.deleteById(id);
  }

  @Override
  public void update(int id, CategoryDto addressDto) {
    Category category = modelMapper.map(addressDto, Category.class);
    categoryRepo.findById(id).map(st -> {
      st.setName(category.getName());
      st.setProductList(category.getProductList());

      return categoryRepo.save(st);
    });

  }
}
