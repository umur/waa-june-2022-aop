package edu.miu.aop.dtos;

import edu.miu.aop.entity.User;
import lombok.Data;

import java.util.Date;

@Data
public class TodoDto {

    private int id;
    private String title;
    private String description;
    private Date createdAt;
    private User user;
}
