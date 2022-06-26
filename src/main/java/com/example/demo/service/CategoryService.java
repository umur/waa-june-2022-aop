package com.example.demo.service;

import com.example.demo.entity.Category;
import com.example.demo.repo.CategoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepo categoryRepo;
    public void save(Category category){
        categoryRepo.save(category);
    }
    public Category getById(int id){
        var res= categoryRepo.findById(id);
        return res.orElse(null);
    }
    public List<Category> getAll(){
        var res= categoryRepo.findAll();
        List<Category> categories= new ArrayList<>();
        res.forEach(categories::add);
        return categories;
    }

    public void delete(int id){
        categoryRepo.deleteById(id);
    }

    public void update(int id, Category category){
        categoryRepo.deleteById(id);
        categoryRepo.save(category);
    }

}
