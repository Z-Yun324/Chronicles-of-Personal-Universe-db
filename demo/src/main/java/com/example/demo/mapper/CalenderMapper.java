package com.example.demo.mapper;

import com.example.demo.pojo.CalenderList;
import com.example.demo.pojo.UserAccount;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface CalenderMapper {

    int insertCalender(CalenderList calenderList);

    void deleteCalenderById(int id);

    List<CalenderList>getCalendersByUserId(int userid);

    int updateCalenderById(CalenderList calenderList);

}
