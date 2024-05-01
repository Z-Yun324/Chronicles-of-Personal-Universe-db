package com.example.demo.Controller;

import com.example.demo.Service.UserAccountServiceImpl;
import com.example.demo.pojo.UserAccount;
import com.example.demo.utils.EncrypAES;
import com.example.demo.utils.JWTutils;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class UserAccountController {
    private UserAccountServiceImpl userAccountServiceImpl;
    private JWTutils jwTutils;
    public UserAccountController(UserAccountServiceImpl userAccountServiceImpl, JWTutils jwTutils) {
        this.userAccountServiceImpl = userAccountServiceImpl;
        this.jwTutils = jwTutils;
    }


    //-----------------------------------------------------------------------
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, Object> json) throws Exception {
        String userName = (String) json.get("userName");
        String password =  (String) json.get("password");
        boolean rememberMe  = Boolean.parseBoolean(json.get("rememberMe").toString());

        if (userAccountServiceImpl.isValidUser(userName, password)) {
            ObjectMapper objectMapper = new ObjectMapper();

            String subJson = objectMapper.writeValueAsString(Map.of("userName", userName, "password", password, "rememberMe", rememberMe ));
            String token = JWTutils.creatJWT(subJson, null);
            String encryptedToken = jwTutils.encrypt(token);
            return ResponseEntity.ok("token:" + encryptedToken);
           // return ResponseEntity.ok(json.toString());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("用戶名或密碼錯誤，請重新輸入 ! ");
        }
    }
    @GetMapping("/secureData")
    public ResponseEntity<String> getSecureData(@RequestHeader("Authorization") String authorizationHeader) throws Exception{
        // 解析 JWT
        String decryptedToken = jwTutils.decrypt(authorizationHeader);
        String jwt = decryptedToken.replace("Bearer ", "");
        Claims claims = JWTutils.parseJWT(jwt);

        // 从 JWT 中获取用户名
        String username = claims.getSubject();

        // 这里可以根据用户名获取用户数据并返回给客户端
        return ResponseEntity.ok("Hello, " + username + "! This is secure data.");
    }

        //-----------------------------------------------------------------------
        /*@PostMapping("/register")
        public String register(@RequestParam("userName") String userName, @RequestParam("password") String password,@RequestParam("nickName") String nickName,@RequestParam("email") String email)throws Exception {
            // 檢查使用者名稱是否已經被註冊
            UserAccount data = userAccountServiceImpl.findUserAccountByUserName(userName);
            if (data != null) {
                return "已有此帳號";
            }
            byte[] keyBytes = "0123456789abcdef".getBytes(); // 16字節的密鑰
            EncrypAES de1 = new EncrypAES(keyBytes);
            byte[] encontent = de1.Encrytor(password);
            userAccountServiceImpl.insertUser(userName,Base64.encodeBase64String(encontent),nickName,email);
            return "註冊成功";
        }*/
        @PostMapping("/register")
        public String register(@RequestBody Map<String, Object> json)throws Exception {
            String userName = (String) json.get("userName");
            String password =  (String) json.get("password");
            String nickName = (String) json.get("nickName");
            String email =  (String) json.get("email");
            // 檢查使用者名稱是否已經被註冊
            UserAccount data = userAccountServiceImpl.findUserAccountByUserName(userName);
            if (data != null) {
                return "已有此帳號";
            }
            byte[] keyBytes = "0123456789abcdef".getBytes(); // 16字節的密鑰
            EncrypAES de1 = new EncrypAES(keyBytes);
            byte[] encontent = de1.Encrytor(password);
            userAccountServiceImpl.insertUser(userName, Base64.encodeBase64String(encontent),nickName,email);
            return "註冊成功";
        }

}

