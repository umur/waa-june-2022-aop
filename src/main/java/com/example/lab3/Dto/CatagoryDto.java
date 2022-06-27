package com.example.lab3.Dto;

import com.example.lab3.Domain.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CatagoryDto {
    private int id;
    private String name;

    private List<Product> products;
}
