package edu.miu.springdata.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String comment;

    @ManyToOne( fetch = FetchType.LAZY)
    @JsonBackReference
    private User user;

    @ManyToOne( fetch = FetchType.LAZY)
    @JsonBackReference
    private Product product;

}
