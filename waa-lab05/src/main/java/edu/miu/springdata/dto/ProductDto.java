package edu.miu.springdata.dto;

import edu.miu.springdata.entity.Category;
import lombok.Data;

import java.util.List;

@Data
public class ProductDto {

    private int id;

    private String name;
    private int price;
    private int rating;
    private List<Category> categorys;
}
