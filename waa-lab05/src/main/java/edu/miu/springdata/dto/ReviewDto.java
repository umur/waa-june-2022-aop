package edu.miu.springdata.dto;

import edu.miu.springdata.entity.Category;
import edu.miu.springdata.entity.Product;
import edu.miu.springdata.entity.User;
import lombok.Data;

import javax.persistence.ManyToOne;
import java.util.List;

@Data
public class ReviewDto {

    private int id;
    private String comment;
    private User user;
    private Product product;
}
