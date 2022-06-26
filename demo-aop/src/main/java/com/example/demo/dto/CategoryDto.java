package com.example.demo.dto;

import com.example.demo.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
  private int id;
  private String name;
  private List<Product> productList = new ArrayList<>();
}
