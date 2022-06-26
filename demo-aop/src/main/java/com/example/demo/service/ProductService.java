package com.example.demo.service;

import com.example.demo.dto.ProductDto;
import com.example.demo.entity.Category;
import com.example.demo.entity.Product;

import java.util.List;


public interface ProductService {
  List<ProductDto> findAllProduct();

  void createProduct(ProductDto dto);

  public void delete(int id);

  public void update(int id, ProductDto addressDto);

  List<ProductDto> findAllByPriceAfter(double checkPrice);
//  List<ProductDto> findAllByCategoryAndPriceBefore(Category category, double checkprice);
  List<ProductDto> findAllByNameContains(String checkName);
}
