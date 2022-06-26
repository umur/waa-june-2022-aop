package com.example.lab5.entity;


import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ActivityLog")
@Data
@ToString
public class ActivityLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Temporal(TemporalType.DATE)
    private Date date;

    private String operation;
    private long duration;
}
