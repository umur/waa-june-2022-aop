package com.lab5.Spring.aop.dto;

import com.lab5.Spring.aop.model.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private int id;
    private String name;
    private int rating;
    private double price;
    private Category category;
}
