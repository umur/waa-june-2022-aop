package miu.edu.bimapping.entity;

import lombok.Data;

import javax.persistence.*;

@Entity@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private String price;
    private Double rating;

    @ManyToOne
    private Category category;
}
