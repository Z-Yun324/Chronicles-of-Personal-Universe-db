package com.example.demo.mapper;

import com.example.demo.pojo.CalenderList;
import com.example.demo.pojo.UserAccount;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Time;
import java.sql.Timestamp;

@Mapper
public interface CalenderMapper {

    int insertCalender(CalenderList calenderList);

    int deleteCalenderById(int id);
}
