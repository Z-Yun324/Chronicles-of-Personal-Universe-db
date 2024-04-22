package com.example.demo.Controller;

import com.example.demo.Service.CalenderService;
import com.example.demo.Service.UserAccountServiceImpl;
import com.example.demo.pojo.CalenderList;
import com.example.demo.pojo.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalenderController {

    @Autowired
    private CalenderService calenderService;

    @PostMapping("/insertcalender")
    public String insertCalender(@RequestBody CalenderList calenderList){
        
        // 調用 CalenderService 的 insert 方法，將接收到的 calenderList 傳遞給 insert 方法
        boolean success = calenderService.insert(calenderList);

        // 根據 insert 方法的返回值，返回相應的響應結果
        if (success) {
            return "新增成功";
        } else {
            return "新增失敗";
        }

    }

    @DeleteMapping("/deletecalender/{id}")
    public String deleteCalender(@PathVariable("id") int id){
        calenderService.delete(id);
        return "刪除成功";
    }

}
