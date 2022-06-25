package com.example.lab5.entity;


import javax.persistence.*;
import java.sql.Date;

@Entity
public class ActivityLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    private String operation;
    private long duration;
}
