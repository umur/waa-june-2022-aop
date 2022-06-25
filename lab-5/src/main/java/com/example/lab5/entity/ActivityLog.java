package com.example.lab5.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
public class ActivityLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Temporal(TemporalType.DATE)
    private Date date;

    private String operation;
    private long duration;
}
