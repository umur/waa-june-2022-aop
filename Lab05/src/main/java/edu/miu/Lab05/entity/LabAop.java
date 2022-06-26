package edu.miu.Lab05.entity;


import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;


@Entity
@Table(name="tblaop")
@Data
@RequiredArgsConstructor
public class LabAop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private LocalDate date;
    private Long duration;
    private String operation;
}
