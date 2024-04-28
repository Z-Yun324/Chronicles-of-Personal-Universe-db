package com.example.demo.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class Notes {
    private int note_id;
    private int user_id;
    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp created_at;
    private String tag_name;
    private String tag_color;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp created_tag_time;
}
