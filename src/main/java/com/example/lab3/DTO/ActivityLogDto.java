package com.example.lab3.DTO;

import lombok.Data;

import java.time.LocalDate;
@Data
public class ActivityLogDto {
    private LocalDate date;
    private String operation;
    private long duration;
}
