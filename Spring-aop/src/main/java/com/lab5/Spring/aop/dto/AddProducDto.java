package com.lab5.Spring.aop.dto;

import lombok.Data;

@Data
public class AddProducDto {
    private String name;
    private int rating;
    private double price;
    private int category_id;
}
