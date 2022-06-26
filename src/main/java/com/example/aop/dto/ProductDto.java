package com.example.aop.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class ProductDto {

    private String name;
    private double price;
    private double rating;

    private List<ReviewDto> reviews;
}
