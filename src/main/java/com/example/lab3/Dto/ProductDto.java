package com.example.lab3.Dto;

import com.example.lab3.Domain.Catagory;
import com.example.lab3.Domain.Uni_Directinal.JoinTable.Review;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private int id;
    private String name;
    private Long price;
    private String rating;

    private Catagory catagory;
    private List<Review> reviews;


}
