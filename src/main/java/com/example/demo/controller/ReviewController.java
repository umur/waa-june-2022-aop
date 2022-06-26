package com.example.demo.controller;

import com.example.demo.entity.Review;
import com.example.demo.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("labs/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private ReviewService reviewService;

    @PostMapping
    public void save(@RequestBody Review u){
        reviewService.save(u);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        reviewService.delete(id);
    }

    @PutMapping("/{id}")
    public  void update(@PathVariable int id, @RequestBody Review u){
        reviewService.update(id,u);
    }

    @GetMapping
    public List<Review> getAll(){
        return reviewService.getAll();
    }


    @GetMapping("/products/{pid}")
    public List<Review> getAllByProductId(@PathVariable int pid){
        return reviewService.getAllByProductId(pid);
    }

    @GetMapping("/{id}")
    public Review getById(@PathVariable int id){
        return reviewService.getById(id);
    }





}
