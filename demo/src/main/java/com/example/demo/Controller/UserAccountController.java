package com.example.demo.Controller;

import com.example.demo.Service.UserAccountServiceImpl;
import com.example.demo.utils.EncrypAES;
import com.example.demo.utils.JWTutils;
import io.jsonwebtoken.Claims;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<String> login(@RequestParam("username") String name, @RequestParam("password") String password) throws Exception {
        if (userAccountServiceImpl.isValidUser(name, password)) {
            String token = JWTutils.creatJWT(name, null);
            System.out.println("生成token=:" + token);
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("用户名或密码错误");
        }
    }
    @GetMapping("/secure-data")
    public ResponseEntity<String> getSecureData(@RequestHeader("Authorization") String authorizationHeader) throws Exception{
        // 解析 JWT
        String jwt = authorizationHeader.replace("Bearer ", "");
        Claims claims = JWTutils.parseJWT(jwt);

        // 从 JWT 中获取用户名
        String username = claims.getSubject();

        // 这里可以根据用户名获取用户数据并返回给客户端
        return ResponseEntity.ok("Hello, " + username + "! This is secure data.");
    }

        //-----------------------------------------------------------------------
        @PostMapping("/register")
        public String register(@RequestParam("username") String username, @RequestParam("password") String password,@RequestParam("nickname") String nickname,@RequestParam("email") String email)throws Exception {
            byte[] keyBytes = "0123456789abcdef".getBytes(); // 16字節的密鑰
            EncrypAES de1 = new EncrypAES(keyBytes);
            byte[] encontent = de1.Encrytor(password);
            userAccountServiceImpl.insertUser(username,Base64.encodeBase64String(encontent),nickname,email);
            return "註冊成功";
        }
        //-----------------------------------------------------------------------
/*
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(@ModelAttribute MemberAccountVO memberAccountVO) {

        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String doRegister(
            @ModelAttribute MemberAccountVO memberAccountVO,
            RedirectAttributes redirectAttributes) {

        Optional<String> optional = memberAccountService.register(memberAccountVO);
        String message = optional.orElse("註冊成功");
        redirectAttributes.addFlashAttribute("MESSAGE", message);
        return "redirect:login";
    }*/

}

