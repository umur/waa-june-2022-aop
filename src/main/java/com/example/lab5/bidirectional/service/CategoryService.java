package com.example.lab5.bidirectional.service;

import com.example.lab5.bidirectional.entity.Category;

import java.util.List;

public interface CategoryService {
    void save(Category category);

    void delete(int id);

    Category findById(int id);

    List<Category> getAll();
}
