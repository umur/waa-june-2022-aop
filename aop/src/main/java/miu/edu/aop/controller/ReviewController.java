package miu.edu.aop.controller;

import miu.edu.aop.aspect.annotation.ExecutionTime;
import miu.edu.aop.aspect.annotation.LogMe;
import miu.edu.aop.dto.ReviewDto;
import miu.edu.aop.service.ReviewService;
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
    public List<ReviewDto> findAll() {
        return reviewService.findAll();
    }

    @PostMapping
    @LogMe
    @ExecutionTime
    public void create(@RequestBody ReviewDto review) {
        reviewService.create(review);
    }

    @PutMapping("/{id}")
    @LogMe
    @ExecutionTime
    public ReviewDto update(@RequestBody ReviewDto review, @PathVariable int id) {
        return reviewService.update(review, id);
    }

    @DeleteMapping("/{id}")
    @LogMe
    @ExecutionTime
    public void delete(@PathVariable int id) {
        reviewService.delete(id);
    }
}
