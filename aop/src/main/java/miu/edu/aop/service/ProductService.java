package miu.edu.aop.service;

import miu.edu.aop.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> findAll();
    void create(ProductDto product);
    ProductDto update(ProductDto product, int id);
    void delete(int id);
}
