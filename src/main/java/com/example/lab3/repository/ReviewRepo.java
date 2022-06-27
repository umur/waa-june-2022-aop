package com.example.lab3.repository;

import com.example.lab3.Domain.Uni_Directinal.JoinTable.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ReviewRepo extends JpaRepository<Review,Integer> {
    List<Review> findAllById(Long id);
}
