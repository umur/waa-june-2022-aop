package miu.edu.aopimplementation.controller;

import miu.edu.aopimplementation.aspect.annotation.ExecutionTime;
import miu.edu.aopimplementation.aspect.annotation.LogMe;
import miu.edu.aopimplementation.dto.ReviewDto;
import miu.edu.aopimplementation.entity.Review;
import miu.edu.aopimplementation.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @ExecutionTime
    @LogMe
    @GetMapping
    public Collection<ReviewDto> findAll(){
        return reviewService.getAllReview();
    }

    @ExecutionTime
    @LogMe
    @PostMapping
    public Review addReview(@RequestBody ReviewDto reviewDto){
        return reviewService.addReview(reviewDto);
    }

    @ExecutionTime
    @LogMe
    @PutMapping("/{id}")
    public Review Update(@RequestBody ReviewDto reviewDto, @PathVariable Integer id){
        return reviewService.updateReview(reviewDto, id);
    }

    @ExecutionTime
    @LogMe
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        reviewService.deleteReview(id);
    }
}
