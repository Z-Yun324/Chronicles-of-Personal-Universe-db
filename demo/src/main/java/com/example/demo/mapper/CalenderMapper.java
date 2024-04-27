package com.example.demo.mapper;

import com.example.demo.pojo.Calender;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CalenderMapper {

    int insertCalender(Calender calender);

    void deleteCalenderById(int id);

    List<Calender>getCalendersByUserId(int userid);

    int updateCalenderById(Calender calender);

}
