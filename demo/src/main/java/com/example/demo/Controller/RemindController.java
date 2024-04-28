package com.example.demo.Controller;

import com.example.demo.Service.RemindService;
import com.example.demo.pojo.Notes;
import com.example.demo.pojo.RemindList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RemindController {

    @Autowired
    private RemindService remindService;

    @PostMapping("/insertRemind")
    public String insert(@RequestBody RemindList remindList){
        boolean success = remindService.insertRemind(remindList);
        if (success) {
            return "新增成功";
        } else {
            return "新增失敗";
        }
    }

    @GetMapping("/selectRemind/{userid}")
    public List<RemindList> select(@PathVariable("userid")int userid){
        return remindService.getRemindByUserId(userid);
    }
    @DeleteMapping("/deleteRemind/{id}")
    public String delete(@PathVariable("id")int id){
        remindService.deleteRemindById(id);
        return "刪除成功";
    }

    @PostMapping("/updateRemind")
    public String update(@RequestBody RemindList remindList){
        boolean success = remindService.updateRemindById(remindList);
        if (success) {
            return "新增成功";
        } else {
            return "新增失敗";
        }
    }
}
