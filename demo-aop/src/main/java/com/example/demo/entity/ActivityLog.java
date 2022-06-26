package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class ActivityLog {
  @Id
  @GeneratedValue
  private int id;
  private Date date;
  private long operation;
  private long duration;

}
