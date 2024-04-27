package com.example.demo.Service;

import com.example.demo.mapper.CalenderMapper;
import com.example.demo.pojo.Calender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Service
public class CalenderService {

    @Autowired
    private CalenderMapper calenderMapper;

    /**
     * @param newEvent 新的日曆事件
     * @return 新事件的 X 變量值，或者插入失敗返回 0
     */
    public int insertCalender(Calender newEvent) {
        // 獲取當前用戶的所有日曆事件，包括已存在的和新增的
        Calender[] existingEvents = calenderMapper.getCalendersByUserId(newEvent.getUser_id()).toArray(new Calender[0]);

        // 計算衝突數量
        int conflictCount = countConflicts(newEvent, existingEvents);

        // 如果衝突數量超過三個，則返回 0，表示插入失敗
        if (conflictCount > 3) {
            return 0;
        }

        // 初始化 X 變量
        int xVariable = 1;

        // 如果衝突數量不為 0，則根據衝突數量設置 X 變量
        if (conflictCount > 0) {
            // 如果衝突數量為 1，則將 X 變量設置為 2
            if (conflictCount == 1) {
                xVariable = 2;
            }
            // 如果衝突數量為 2，則將 X 變量設置為 3
            else if (conflictCount == 2) {
                xVariable = 3;
            }
            // 如果衝突數量超過 2，則將 X 變量設置為 0
            else {
                xVariable = 0;
            }
        }

        // 插入新的日曆事件
        int rowsAffected = calenderMapper.insertCalender(newEvent);

        // 如果插入成功，則返回新事件的 X 變量值
        if (rowsAffected > 0) {
            return xVariable;
        } else {
            // 如果插入失敗，返回 0
            return 0;
        }
    }

    /**
     * 計算新事件與現有事件之間的衝突數量。
     *
     * @param newEvent       新的日曆事件
     * @param existingEvents 現有的日曆事件數組
     * @return 衝突數量
     */
    private int countConflicts(Calender newEvent, Calender[] existingEvents) {
        int conflictCount = 0;
        for (Calender existingEvent : existingEvents) {
            if (isConflict(newEvent, existingEvent)) {
                conflictCount++;
            }
        }
        return conflictCount;
    }

    /**
     * 檢查新事件與現有事件之間是否存在衝突。
     *
     * @param newEvent       新的日曆事件
     * @param existingEvent  現有的日曆事件
     * @return 如果存在衝突返回 true，否則返回 false
     */
    private boolean isConflict(Calender newEvent, Calender existingEvent) {
        return newEvent.getStart_time().before(existingEvent.getEnd_time()) && existingEvent.getStart_time().before(newEvent.getEnd_time());
    }

    public void delete(int id) {
        calenderMapper.deleteCalenderById(id);
    }

    public List<Calender>getCalendersByUserId(int userid){
        return calenderMapper.getCalendersByUserId(userid);
    }

    public boolean updateCalender(Calender calender) {
        int rowsAffected = calenderMapper.updateCalenderById(calender);
        return rowsAffected > 0;
    }

}
