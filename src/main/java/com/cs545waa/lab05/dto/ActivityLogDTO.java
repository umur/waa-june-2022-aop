package com.cs545waa.lab05.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityLogDTO {
    private int id;
    private LocalDate date;
    private String operation;
    private long duration;
}
