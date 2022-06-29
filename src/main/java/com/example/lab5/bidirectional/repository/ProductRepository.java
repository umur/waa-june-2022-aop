package com.example.lab5.bidirectional.repository;

import com.example.lab5.bidirectional.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product,Integer> {
    List<Product> findAll();
    List<Product> getProductByPriceGreaterThan(double price);
    List<Product> getProductsByPriceLessThanAndCategory_Name(double price,String category);
    List<Product> getProductsByNameContains(String name);
    List<Product> getProductsByUserId(int id);
}
