package miu.edu.bimapping.service.impl;

import miu.edu.bimapping.dto.CategoryDto;
import miu.edu.bimapping.entity.Category;
import miu.edu.bimapping.repository.CategoryRepository;
import miu.edu.bimapping.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public Collection<CategoryDto> getAllCategory() {
        List<Category> categories = (List<Category>) categoryRepository.findAll();
        List<CategoryDto> categoriesDto = categories.stream()
                .map(st ->toDto(st))
                .collect(Collectors.toList());
        return categoriesDto;
    }

    @Override
    public Category addCategory(CategoryDto categoryDto) {
        Category category = toEntity(categoryDto);
        return categoryRepository.save(category) ;
    }

    @Override
    public void deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category updateCategory(CategoryDto categoryDto, Integer id) {
        Category category = toEntity(categoryDto);
        categoryRepository.findById(id).map(cat->{
            cat.setName(category.getName());
            cat.setProducts(category.getProducts());
            return categoryRepository.save(cat);
        });
        return category;
    }

    public CategoryDto toDto(Category category){
        CategoryDto categoryDto = mapper.map(category, CategoryDto.class);
        return categoryDto;
    }

    public Category toEntity(CategoryDto categoryDto){
        Category category = mapper.map(categoryDto, Category.class);
        return category;
    }
}
