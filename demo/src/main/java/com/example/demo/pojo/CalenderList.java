package com.example.demo.pojo;

import lombok.Data;

import java.sql.Time;
import java.sql.Timestamp;

@Data
public class CalenderList {
    private int c_id;
    private String c_color;
    private int user_id;
    private String event_date;
    private Time start_time;
    private Time end_time;
    private String things_description;
    private Timestamp reminder_time;
    private String remark;
}
