package com.example.demo.Controller;

import com.example.demo.Dao.LoginDao;
import com.example.demo.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private LoginDao loginService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody MemberService memberService){
        if(loginService.isValidUser(memberService.getAccount(),memberService.getPassword())){
            return ResponseEntity.ok("登入成功");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("登入失敗");
        }
    }
}
