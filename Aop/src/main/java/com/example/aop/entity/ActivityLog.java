package com.example.aop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityLog {
    @Id @GeneratedValue
    private int id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    private String duration;
}
