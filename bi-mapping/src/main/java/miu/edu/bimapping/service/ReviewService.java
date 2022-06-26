package miu.edu.bimapping.service;

import miu.edu.bimapping.dto.ReviewDto;
import miu.edu.bimapping.entity.Review;

import java.util.List;

public interface ReviewService {
    public List<ReviewDto> getAllReview();

    public Review addReview(ReviewDto reviewDtoDto);

    public void deleteReview(Integer id);

    public Review updateReview(ReviewDto reviewDto, Integer id);
}
