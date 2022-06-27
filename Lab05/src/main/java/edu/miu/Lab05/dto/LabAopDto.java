package edu.miu.Lab05.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LabAopDto {

    private int id;
    private Date created;
    private Long duration;
    private String operation;

    public LabAopDto(Date date, String operation, long duration) {
        this.created = date;
        this.operation = operation;
        this.duration = duration;
    }
}
