package com.example.demo.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

@Data
public class Calender {
    private int c_id;
    private String c_color;
    private Integer user_id;
    private String event_date;
    @JsonFormat(pattern = "HH:mm:ss")
    private Time start_time;
    @JsonFormat(pattern = "HH:mm:ss")
    private Time end_time;
    private String things_description;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp reminder_time;
    private String remark;

    // 添加 X 变量字段
    private int xVariable;

}