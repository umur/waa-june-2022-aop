package miu.edu.bimapping.service.impl;

import miu.edu.bimapping.dto.ReviewDto;
import miu.edu.bimapping.entity.Review;
import miu.edu.bimapping.repository.ReviewRepository;
import miu.edu.bimapping.service.ReviewService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public List<ReviewDto> getAllReview() {
        List<Review> reviews = (List<Review>) reviewRepository.findAll();
        List<ReviewDto> reviewsDto = reviews.stream()
                .map(st ->toDto(st))
                .collect(Collectors.toList());
        return reviewsDto;
    }

    @Override
    public Review addReview(ReviewDto reviewDto) {
        Review review = toEntity(reviewDto);
        return reviewRepository.save(review) ;
    }

    @Override
    public void deleteReview(Integer id) {
        reviewRepository.deleteById(id);
    }

    @Override
    public Review updateReview(ReviewDto reviewDto, Integer id) {
        Review review = toEntity(reviewDto);
        reviewRepository.findById(id).map(reviews->{
            reviews.setComment(review.getComment());
            return this.reviewRepository.save(reviews);
        });
        return review;
    }

    public ReviewDto toDto(Review review){
        ReviewDto reviewDto = mapper.map(review, ReviewDto.class);
        return reviewDto;
    }

    public Review toEntity(ReviewDto reviewDto){
        Review review = mapper.map(reviewDto, Review.class);
        return review;
    }
}
