package com.example.lab5.bidirectional.service;

import com.example.lab5.bidirectional.dto.ProductDTO;
import com.example.lab5.bidirectional.entity.Product;

import java.util.List;


public interface ProductService {
    void save(Product product);

    void delete(int id);

    Product findById(int id);

    List<ProductDTO> getAll();

    List<ProductDTO> getProductByPriceGreaterThan(double parseDouble);

    List<ProductDTO> getProductsByPriceLessThanAndCategory_Name(double price,String category);

    List<ProductDTO> getProductsByNameContains(String name);

    List<ProductDTO> getProductsByUserId(int id);

}
