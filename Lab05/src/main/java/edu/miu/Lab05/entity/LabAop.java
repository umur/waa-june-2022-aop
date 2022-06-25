package edu.miu.Lab05.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="tblaop")
@Data
public class LabAop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    @Temporal(TemporalType.DATE)
    private Date date;
    private Long duration;
    private String operation;
}
