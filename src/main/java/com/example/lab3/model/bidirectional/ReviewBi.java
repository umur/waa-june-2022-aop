package com.example.lab3.model.bidirectional;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data

public class ReviewBi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String comment;

    @ManyToOne
    UserBi userBi;


}
