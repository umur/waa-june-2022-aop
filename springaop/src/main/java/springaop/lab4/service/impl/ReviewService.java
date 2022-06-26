package springaop.lab4.service.impl;


import springaop.lab4.dto.ReviewDto;

import java.util.List;

public interface ReviewService {

    List<ReviewDto> findAllReviewsByProductId(int productId);
}
