package miu.edu.aopimplementation.controller;

import miu.edu.aopimplementation.aspect.annotation.ExecutionTime;
import miu.edu.aopimplementation.aspect.annotation.LogMe;
import miu.edu.aopimplementation.dto.CategoryDto;
import miu.edu.aopimplementation.entity.Category;
import miu.edu.aopimplementation.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @ExecutionTime
    @LogMe
    @GetMapping
    public Collection<CategoryDto> findAll(){
        return categoryService.getAllCategory();
    }

    @ExecutionTime
    @LogMe
    @PostMapping
    public Category addCategory(@RequestBody CategoryDto categoryDto){
        return categoryService.addCategory(categoryDto);
    }


    @ExecutionTime
    @LogMe
    @PutMapping("/{id}")
    public Category Update(@RequestBody CategoryDto categoryDto, @PathVariable Integer id){
        return categoryService.updateCategory(categoryDto, id);
    }


    @ExecutionTime
    @LogMe
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        categoryService.deleteCategory(id);
    }
}
