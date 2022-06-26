package miu.edu.bimapping.entity;

import lombok.Data;

import javax.persistence.*;

@Entity@Data
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String comment;

    @ManyToOne
    private User user;
}
