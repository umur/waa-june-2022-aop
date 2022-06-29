package com.example.lab5.bidirectional.controller;


import com.example.lab5.bidirectional.entity.Category;
import com.example.lab5.bidirectional.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/save")
    public void createCategory(@RequestBody Category category){
        categoryService.save(category);
    }



    @GetMapping("/get")
    public List<Category> getAll(){
        return categoryService.getAll();
    }

    //what is response entity
    @GetMapping("/get/{id}")
    public ResponseEntity<Category> getById(@PathVariable int id){
        var category = categoryService.findById(id);
        return ResponseEntity.ok(category);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        categoryService.delete(id);
    }
}
