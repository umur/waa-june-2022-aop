package springaop.lab4.controller;



import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springaop.lab4.dto.ReviewDto;
import springaop.lab4.service.impl.ReviewService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {


    private final ReviewService reviewService;


@GetMapping(path = "{id}")
    public List<ReviewDto> findAllReviewsByProductId(@PathVariable("id")int productId) {
        return  reviewService.findAllReviewsByProductId(productId);
    }
}
