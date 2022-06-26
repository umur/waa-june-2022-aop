package miu.edu.bimapping.controller;

import miu.edu.bimapping.dto.CategoryDto;
import miu.edu.bimapping.entity.Category;
import miu.edu.bimapping.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public Collection<CategoryDto> findAll(){
        return categoryService.getAllCategory();
    }
    @PostMapping
    public Category addCategory(@RequestBody CategoryDto categoryDto){
        return categoryService.addCategory(categoryDto);
    }

    @PutMapping("/{id}")
    public Category Update(@RequestBody CategoryDto categoryDto, @PathVariable Integer id){
        return categoryService.updateCategory(categoryDto, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        categoryService.deleteCategory(id);
    }
}
