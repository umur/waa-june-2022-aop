package com.cs545waa.lab05.service;

import com.cs545waa.lab05.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    public List<ProductDTO> readAll();
    public void create(ProductDTO dto);
}
