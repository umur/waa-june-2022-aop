package com.waa.lab3.service.impl;

import com.waa.lab3.entity.Review;
import com.waa.lab3.repo.ReviewRepository;
import com.waa.lab3.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    @Override
    public Review findReviewByProductId(Long productId) {
        return reviewRepository.findReviewByProductId(productId);
    }
}
