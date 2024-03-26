package com.example.demo.pojo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Notes {
    private int note_id;
    private int user_id;
    private String content;
    private Timestamp created_at;
    private String tag_name;
    private String tag_color;
    private Timestamp created_tag_time;
}
