package com.example.lab3.service;

import com.example.lab3.DTO.ProductDto;

import java.util.List;

public interface ProductService {
    void save(ProductDto p);

    void delete(long id);

    void update(long id, ProductDto productDto);


    List<ProductDto> findAll();

}
