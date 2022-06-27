package com.waa.lab3.service;

import com.waa.lab3.entity.Review;

public interface ReviewService {

    Review findReviewByProductId(Long productId);

}
