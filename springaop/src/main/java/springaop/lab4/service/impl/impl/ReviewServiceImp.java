package springaop.lab4.service.impl.impl;


import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import springaop.lab4.domain.Product;
import springaop.lab4.domain.Review;
import springaop.lab4.dto.ReviewDto;
import springaop.lab4.repository.ProductRepo;
import springaop.lab4.service.impl.ReviewService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewServiceImp implements ReviewService {

private final ProductRepo productRepo;
    private final ModelMapper modelMapper;
    @Override
    public List<ReviewDto> findAllReviewsByProductId(int productId) {
        List<ReviewDto> review = new ArrayList<>();
        for (Product product: productRepo.findAll()){
            if (product.getId()==productId){
                for (Review r :product.getReviews()){
                    review.add(modelMapper.map(r,ReviewDto.class));
                }
            }
        }
        return review;
    }
}
