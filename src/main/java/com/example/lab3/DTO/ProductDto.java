package com.example.lab3.DTO;

import com.example.lab3.model.bidirectional.CategoryBi;
import lombok.Data;

@Data
public class ProductDto {

    private String name;
    private double price;
    private int rating;
    private CategoryBi categoryBi;
}
