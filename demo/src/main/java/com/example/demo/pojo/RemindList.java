package com.example.demo.pojo;

import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;

@Data
public class RemindList {
    private int remind_id;
    private int user_id;
    private String thing_description;
    private Date completion_time;
    private Timestamp reminder_time;
    private Priority priority;
}
