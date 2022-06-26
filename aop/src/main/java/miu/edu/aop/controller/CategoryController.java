package miu.edu.aop.controller;

import miu.edu.aop.aspect.annotation.ExecutionTime;
import miu.edu.aop.aspect.annotation.LogMe;
import miu.edu.aop.dto.CategoryDto;
import miu.edu.aop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping
    @LogMe
    @ExecutionTime
    public List<CategoryDto> findAll() {
        return categoryService.findAll();
    }

    @PostMapping
    @LogMe
    @ExecutionTime
    public void create(@RequestBody CategoryDto category) {
        categoryService.createCategory(category);
    }

    @PutMapping("/{id}")
    @LogMe
    @ExecutionTime
    public CategoryDto update(@RequestBody CategoryDto category, @PathVariable int id) {
        return categoryService.update(category, id);
    }

    @DeleteMapping("/{id}")
    @LogMe
    @ExecutionTime
    public void delete(@PathVariable int id) {
        categoryService.delete(id);
    }
}
