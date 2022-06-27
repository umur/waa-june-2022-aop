package com.example.demo.repo;

import com.example.demo.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends CrudRepository<Product,Integer> {

     List<Product> findAllByPriceGreaterThan(double minPrice);
     List<Product> findAllByCategoryIdAndPriceLessThan(int CatId, double maxPrice);
     List<Product> findAllyByNameContaining(String keyword);
     List<Product> findByReviewsUserId(int id);


}
