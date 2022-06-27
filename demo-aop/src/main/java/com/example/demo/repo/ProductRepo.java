package com.example.demo.repo;

import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends CrudRepository<Product,Integer> {

  List<Product> findAllByPriceAfter(double checkPrice);

//  List<Product> findAllByCategoryAndPriceBefore(Category category, double checkprice);

  List<Product> findAllByNameContains(String checkName);

}
