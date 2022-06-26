package miu.edu.aopimplementation.service;

import miu.edu.aopimplementation.aspect.annotation.ExecutionTime;
import miu.edu.aopimplementation.aspect.annotation.LogMe;
import miu.edu.aopimplementation.dto.ReviewDto;
import miu.edu.aopimplementation.entity.Review;
import org.aspectj.lang.annotation.Pointcut;

import java.util.List;

public interface ReviewService {

    public List<ReviewDto> getAllReview();


    public Review addReview(ReviewDto reviewDtoDto);


    public void deleteReview(Integer id);


    public Review updateReview(ReviewDto reviewDto, Integer id);
}
