package com.example.demo.Controller;

import com.example.demo.Dao.Login;
import com.example.demo.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Login login){
        if(loginService.isValidUser(login.getUsername(),login.getPassword())){
            return ResponseEntity.ok("登入成功");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("登入失敗");
        }
    }
}
