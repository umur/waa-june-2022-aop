package com.example.lab5.bidirectional.service.impl;

import com.example.lab5.bidirectional.dto.ReviewDTO;
import com.example.lab5.bidirectional.entity.Review;
import com.example.lab5.bidirectional.repository.ReviewRepository;
import com.example.lab5.bidirectional.service.ReviewService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public void save(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public void delete(int id) {
        Review review = findById(id);
        if (null != review) {
            reviewRepository.delete(review);
        }
    }

    @Override
    public Review findById(int id) {
        return reviewRepository.findById(id).isPresent() ? reviewRepository.findById(id).get() : null;
    }

    @Override
    public List<ReviewDTO> getAll() {
        return reviewRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ReviewDTO> getReviewBasedOnProductId(int id) {
        return reviewRepository.getReviewsByProductId(id)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    //use model mapper here
    public ReviewDTO toDTO(Review review) {
        return modelMapper.map(review, ReviewDTO.class);
    }

    public Review toEntity(ReviewDTO reviewDTO) {
        return modelMapper.map(reviewDTO, Review.class);
    }
}
