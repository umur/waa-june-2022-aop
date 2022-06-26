package com.example.aop.service;



import com.example.aop.dto.ProductDto;
import com.example.aop.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    List<Product> findAllByPriceGreaterThan(Double price);
    Product findById(int id);
    Product addProduct(ProductDto productDto);
    Product updateProduct(Product product);
    void deleteById(int id);

}
