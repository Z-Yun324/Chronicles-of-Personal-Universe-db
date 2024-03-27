package com.example.demo.Controller;

import com.example.demo.Service.LoginService;
import com.example.demo.Service.MemberService;
import com.example.demo.pojo.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public String login(@RequestParam("username") String name,@RequestParam("password") String password){
        UserAccount user = loginService.getUserByNameAndPassword(name,password);
        if(user != null){
            return "登入成功";
        } else{
            return "登入失敗";
        }
    }

    /*@Autowired
    private LoginDao loginService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody MemberService memberService) throws Exception {
        if(loginService.isValidUser(memberService.getAccount(),memberService.getPassword())){
            return ResponseEntity.ok("登入成功");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("登入失敗");
        }
    }*/
}
