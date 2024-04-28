package com.example.demo.Controller;

import com.example.demo.Service.CalenderService;
import com.example.demo.Service.UserAccountServiceImpl;
import com.example.demo.pojo.Calender;
import com.example.demo.pojo.UserAccount;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CalenderController {

    @Autowired
    private CalenderService calenderService;

    @PostMapping("/insertCalender")
    public String insertCalender(@RequestBody Calender calender) {
        int xVariable = calenderService.insertCalender(calender);

        if (xVariable == 0) {
            return "新增失败，衝突超過三個";
        } else {
            return "新增成功，X 變量為：" + xVariable;
        }
    }

    @DeleteMapping("/deleteCalender/{id}")
    public String deleteCalender(@PathVariable("id") int id){
        calenderService.delete(id);
        return "刪除成功";
    }

    @GetMapping("/selectCalender/{userid}")
    public List<Calender> selectCalender(@PathVariable("userid") int userid){
        return calenderService.getCalendersByUserId(userid);
    }

    @PostMapping("/updateCalender")
    public String updateCalender(@RequestBody Calender calender){
        boolean success = calenderService.updateCalender(calender);
        if (success) {
            return "新增成功";
        } else {
            return "新增失敗";
        }
    }

}
