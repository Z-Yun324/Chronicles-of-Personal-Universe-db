package com.example.demo.Controller;

import com.example.demo.Dao.register;
import com.example.demo.User;
import org.springframework.web.bind.annotation.*;
@RestController
public class MemberController extends register {

    @PostMapping("/register")
    public String create(@RequestBody User user) {
        insert(user);
        return "已註冊";
    }

    @GetMapping("/register/{account}")
    public String read(@PathVariable String account) {
        return "執行資料庫的 Read 操作";
    }
    @PutMapping("/register/{account}")
    public String update(@PathVariable String account,
                         @RequestBody User user) {
        return "執行資料庫的 Update 操作";
    }
    @DeleteMapping("/register/{account}")
    public String delete(@PathVariable String account) {
        return "執行資料庫的 Delete 操作";
    }
}
