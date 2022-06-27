package com.example.lab3.Service.Impl;


import com.example.lab3.Domain.Uni_Directinal.JoinTable.Review;

import com.example.lab3.Dto.ReviewDto;
import com.example.lab3.Service.IReviewService;
import com.example.lab3.repository.ReviewRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.internal.bytebuddy.description.method.MethodDescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.Type;
import java.util.List;
@Service
@Transactional
public class ReviewService implements IReviewService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ReviewRepo reviewRepo;

    public ReviewService(ModelMapper modelMapper, ReviewRepo reviewRepo) {
        this.modelMapper = modelMapper;
        this.reviewRepo = reviewRepo;
    }

    @Override
    public List<ReviewDto> findAll() {
        var reviews=reviewRepo.findAll();

        Type listType=new TypeToken<List<ReviewDto>>(){}.getType();
        return modelMapper.map(reviews,listType);
    }

    @Override
    public ReviewDto findById(int id) {
        Review r= reviewRepo.findById(id).orElseThrow();
        return modelMapper.map(r,ReviewDto.class);
    }

    @Override
    public ReviewDto add(ReviewDto r) {
        var review=modelMapper.map(r, Review.class);
        reviewRepo.save(review);
        return modelMapper.map(review,ReviewDto.class);

    }

    @Override
    public String deleteById(int id) {
        reviewRepo.deleteById(id);
        return "deleted";
    }

    @Override
    public ReviewDto update(int id, ReviewDto r) {
        var review=reviewRepo.findById(id).orElseThrow();
        var r1=modelMapper.map(r,Review.class);
        reviewRepo.save(r1);
        return modelMapper.map(r1,ReviewDto.class);
    }
    public List<ReviewDto> findAllByProductId(Long id){
        var reviews=reviewRepo.findAllById(id);
        Type listType=new TypeToken<List<ReviewDto>>(){}.getType();
        List<ReviewDto> list= modelMapper.map(reviews,listType);
        return list;


    }
}
