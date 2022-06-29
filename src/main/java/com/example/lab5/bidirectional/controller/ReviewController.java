package com.example.lab5.bidirectional.controller;

import com.example.lab5.bidirectional.dto.ReviewDTO;
import com.example.lab5.bidirectional.entity.Review;
import com.example.lab5.bidirectional.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/save")
    public void createReview(@RequestBody Review review){
        reviewService.save(review);
    }

    @GetMapping("/get")
    public List<ReviewDTO> getAll(){
        return reviewService.getAll();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable int id){
        var review = reviewService.findById(id);
        return ResponseEntity.ok(review);
    }

    @GetMapping("/getReview")
    public List<ReviewDTO> getReviewsByProductId(@RequestParam int productId){
        return reviewService.getReviewBasedOnProductId(productId);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        reviewService.delete(id);
    }

}
