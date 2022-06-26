package miu.edu.aop.service;

import miu.edu.aop.dto.ReviewDto;

import java.util.List;

public interface ReviewService {
    List<ReviewDto> findAll();
    void create(ReviewDto review);
    ReviewDto update(ReviewDto review, int id);
    void delete(int id);
}
