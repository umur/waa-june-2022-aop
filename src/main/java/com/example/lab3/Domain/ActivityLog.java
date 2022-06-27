package com.example.lab3.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class ActivityLog {
    @Id
    @GeneratedValue
    private int id;
    private String operation;
    private LocalDate date;
    private Long duration;

    public ActivityLog(String operation, LocalDate date, Long duration) {
        this.operation = operation;
        this.date = date;
        this.duration = duration;
    }
}
