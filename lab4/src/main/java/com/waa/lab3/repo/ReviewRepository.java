package com.waa.lab3.repo;

import com.waa.lab3.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    Review findReviewByProductId(Long id);

}
