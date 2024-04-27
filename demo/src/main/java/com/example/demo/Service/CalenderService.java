package com.example.demo.Service;

import com.example.demo.mapper.CalenderMapper;
import com.example.demo.mapper.UserAccountMapper;
import com.example.demo.pojo.CalenderList;
import com.example.demo.pojo.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalenderService {

    @Autowired
    private CalenderMapper calenderMapper;

    public boolean insert(CalenderList calenderList) {
        int rowsAffected = calenderMapper.insertCalender(calenderList);
        return rowsAffected > 0;
    }

    public void delete(int id) {
        calenderMapper.deleteCalenderById(id);
    }

    public List<CalenderList>getCalendersByUserId(int userid){
        return calenderMapper.getCalendersByUserId(userid);
    }

    public boolean updateCalender(CalenderList calenderList) {
        int rowsAffected = calenderMapper.updateCalenderById(calenderList);
        return rowsAffected > 0;
    }


}
