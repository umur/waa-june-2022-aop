package miu.edu.aop.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private double price;

    private double rating;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Category category;
}

