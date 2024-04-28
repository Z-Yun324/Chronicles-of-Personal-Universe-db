package com.example.demo.mapper;

import com.example.demo.pojo.Notes;
import com.example.demo.pojo.RemindList;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RemindMapper {
    int insertRemind(RemindList remindList);

    List<RemindList> getRemindByUserId(int user_id);

    void deleteRemindById(int n_id);

    int updateRemindById(RemindList remindList);
}
