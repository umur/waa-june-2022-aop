package com.lab5.Spring.aop.service;

import com.lab5.Spring.aop.dto.AddProducDto;
import com.lab5.Spring.aop.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> findAll();

    AddProducDto create(AddProducDto productDto);
}
