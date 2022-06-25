package com.example.lab5.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class ActivityLog {

    @Id
    @GeneratedValue
    private int id;
    private Date date;
    private String operation;
    private String duration;

}
