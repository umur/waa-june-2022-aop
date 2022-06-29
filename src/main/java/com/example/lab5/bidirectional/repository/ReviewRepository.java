package com.example.lab5.bidirectional.repository;

import com.example.lab5.bidirectional.entity.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Integer> {
    List<Review> findAll();
    List<Review> findReviewsByProductId(int id);
}
