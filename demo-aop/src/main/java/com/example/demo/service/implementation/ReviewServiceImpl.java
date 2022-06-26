package com.example.demo.service.implementation;

import com.example.demo.dto.ReviewDto;
import com.example.demo.entity.Review;
import com.example.demo.repo.ReviewRepo;
import com.example.demo.service.ReviewService;
import com.example.demo.util.ListMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
  @Autowired
  ModelMapper modelMapper;
  @Autowired
  ListMapper<Review, ReviewDto> listMapper;
  @Autowired
  ReviewRepo reviewRepo;

  @Override
  public List<ReviewDto> findAllReview() {
    List<Review> reviews = (List<Review>) reviewRepo.findAll();
    List<ReviewDto> reviewDto = (List<ReviewDto>) listMapper.mapList(reviews, new ReviewDto());
    return reviewDto;
  }

  @Override
  public void createReview(ReviewDto reviewDto) {
    Review review = modelMapper.map(reviewDto, Review.class);
    reviewRepo.save(review);
  }

  @Override
  public void delete(int id) {
    reviewRepo.deleteById(id);
  }

  @Override
  public void update(int id, ReviewDto reviewDto) {
    Review review = modelMapper.map(reviewDto, Review.class);
    reviewRepo.findById(id).map(st -> {
      st.setComment(review.getComment());
      return reviewRepo.save(st);
    });

  }

}
