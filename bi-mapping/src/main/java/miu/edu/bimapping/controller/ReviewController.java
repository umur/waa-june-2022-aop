package miu.edu.bimapping.controller;

import miu.edu.bimapping.dto.ReviewDto;
import miu.edu.bimapping.entity.Review;
import miu.edu.bimapping.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public Collection<ReviewDto> findAll(){
        return reviewService.getAllReview();
    }
    @PostMapping
    public Review addReview(@RequestBody ReviewDto reviewDto){
        return reviewService.addReview(reviewDto);
    }

    @PutMapping("/{id}")
    public Review Update(@RequestBody ReviewDto reviewDto, @PathVariable Integer id){
        return reviewService.updateReview(reviewDto, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        reviewService.deleteReview(id);
    }
}
