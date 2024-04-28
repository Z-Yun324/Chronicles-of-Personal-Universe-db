package com.example.demo.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;

@Data
public class RemindList {
    private int remind_id;
    private int user_id;
    private String things_description;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date completion_date;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp reminder_time;
    private int priority;

    // 提供一个方法，用于将整数值转换为枚举类型
    /*public Priority getPriority() {
        switch (priority) {
            case 1:
                return Priority.ONE;
            case 2:
                return Priority.TWO;
            case 3:
                return Priority.THREE;
            case 4:
                return Priority.FOUR;
            default:
                throw new IllegalArgumentException("Invalid priority value: " + priority);
        }
    }

    // 提供一个方法，用于将枚举类型转换为整数值
    public void setPriority(Priority priorityEnum) {
        this.priority = priorityEnum.getValue();
    }*/
}
