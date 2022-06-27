package com.example.lab3.model.unidirectional;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data
@Entity

public class CategoryUni {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany
    @JoinColumn(name="id_category")
    List<ProductUni> productUnis;


}
