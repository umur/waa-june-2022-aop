package edu.miu.Lab05.entity;


import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;


@Entity
@Table(name="ActivityLog")
@Data
@RequiredArgsConstructor
public class LabAop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    @Temporal(TemporalType.DATE)
    private Date created;
    private Long duration;
    private String operation;
}
