package miu.edu.aopimplementation.repository;

import miu.edu.aopimplementation.entity.Review;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Integer> {
}
