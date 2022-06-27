package edu.miu.springdata.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    //@JoinTable // OPTIONAL
    @JsonManagedReference
    private List<Product> products;
}
