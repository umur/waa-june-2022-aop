package com.example.demo.controller;

import com.example.demo.aspect.annotations.ExecutionTime;
import com.example.demo.aspect.annotations.LogMe;
import com.example.demo.dto.ReviewDto;
import com.example.demo.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")

public class ReviewController {
  @Autowired
  ReviewService reviewService;

  @GetMapping
  @LogMe
  @ExecutionTime
  public List<ReviewDto> findAllReview() {

    return reviewService.findAllReview();
  }

  @PostMapping
  @LogMe
  @ExecutionTime
  public void createReview(@RequestBody ReviewDto dto) {
    reviewService.createReview(dto);
  }

  @DeleteMapping("/{id}")
  @LogMe
  @ExecutionTime
  public void deleteReview(@PathVariable int id) {
    reviewService.delete(id);
  }

  @PutMapping("/{id}")
  @LogMe
  @ExecutionTime
  public void update(@RequestBody @PathVariable int id, ReviewDto reviewDto) {

    reviewService.update(id, reviewDto);
  }
}
