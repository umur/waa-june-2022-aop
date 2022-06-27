package edu.miu.cs545.aop.utils;

import edu.miu.cs545.aop.dto.ReviewDto;
import edu.miu.cs545.aop.entity.Review;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewUtils {
    static ModelMapper mapper;
    @Autowired
    public void setModelMapper(ModelMapper modelMapper){
        ReviewUtils.mapper=modelMapper;
    }

    public static ReviewDto parseReviewToReviewDto(Review review){
        return mapper.map(review, ReviewDto.class);
    }

    public static Review parseReviewDtoToReview(ReviewDto reviewDto){
        return mapper.map(reviewDto,Review.class);
    }
}
