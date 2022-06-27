package com.example.demo.service;

import com.example.demo.dto.ReviewDto;

import java.util.List;


public interface ReviewService {
  List<ReviewDto> findAllReview();

  void createReview(ReviewDto dto);

  void delete(int id);

  void update(int id, ReviewDto dto);
}
