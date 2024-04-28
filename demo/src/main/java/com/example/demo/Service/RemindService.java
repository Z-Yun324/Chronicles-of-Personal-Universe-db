package com.example.demo.Service;

import com.example.demo.mapper.RemindMapper;
import com.example.demo.pojo.RemindList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RemindService {

    @Autowired
    private RemindMapper remindMapper;

    public boolean insertRemind(RemindList remindList) {
        int rowsAffected = remindMapper.insertRemind(remindList);
        return rowsAffected > 0;
    }

    public List<RemindList> getRemindByUserId(int user_id){
        return remindMapper.getRemindByUserId(user_id);
    }

    public void deleteRemindById(int r_id){
        remindMapper.deleteRemindById(r_id);
    }

    public boolean updateRemindById(RemindList remindList){
        int rowsAffected = remindMapper.updateRemindById(remindList);
        return rowsAffected > 0;
    }
}
