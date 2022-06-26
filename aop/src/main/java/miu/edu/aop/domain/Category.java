package miu.edu.aop.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    private int id;

    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
