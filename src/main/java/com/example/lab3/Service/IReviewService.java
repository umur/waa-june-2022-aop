package com.example.lab3.Service;

import com.example.lab3.Domain.Uni_Directinal.JoinTable.Review;
import com.example.lab3.Dto.ReviewDto;

import java.util.List;

public interface IReviewService {
    public List<ReviewDto> findAll();
    public ReviewDto  findById(int id);
    public ReviewDto add(ReviewDto r);
    public String deleteById(int id);
    public ReviewDto update(int id,ReviewDto r);
}
