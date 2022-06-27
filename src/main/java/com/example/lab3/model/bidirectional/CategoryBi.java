package com.example.lab3.model.bidirectional;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data
@Entity

public class CategoryBi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "categoryBi")
    List<ProductBi> productBis;


}
