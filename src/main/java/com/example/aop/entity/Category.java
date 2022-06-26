package com.example.aop.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Category {

    @Id
    @GeneratedValue
    private int Id;
    private String name;

    @OneToMany(mappedBy = "category")
    List<Product> productList;

    @ManyToOne(cascade = CascadeType.ALL)
    Category category;

}
