package edu.miu.aop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityLog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    private LocalDate date;
    private String operation;
    private long duration;

    public ActivityLog(LocalDate date, String operation, long duration) {
        this.date = date;
        this.operation = operation;
        this.duration = duration;
    }
}
