package com.example.demo.mapper;

import com.example.demo.pojo.Calender;
import com.example.demo.pojo.Calender;
import com.example.demo.pojo.UserAccount;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface CalenderMapper {

    int insertCalender(Calender calenderList);

    void deleteCalenderById(int id);

    List<Calender>getCalendersByUserId(int userid);

    int updateCalenderById(Calender calenderList);

}
