package com.example.aop.repo;

import com.example.aop.entity.Product;
import com.example.aop.entity.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends CrudRepository<Product, Integer> {

//    Find all products that cost more than minPrice.
    List<Product> findAllByPriceGreaterThan(Double price);
//
//    Find all products in cat category and cost less than maxPrice.
//    List<Product> findProductsByCategoryAndPriceLessThan(Double price);
//
//    Find all products that contain keyword in the name.
    List<Product> findAllByNameContaining(String keyword);
//
//    Find reviews of the product whose id is id.
    @Query("select r from Product p join p.reviews r where r.Id = ?1")
    List<Review> findReviewsByProductId(int id);
}
