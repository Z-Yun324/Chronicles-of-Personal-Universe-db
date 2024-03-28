package com.example.demo.Controller;

import com.example.demo.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/register")
    public String register(@RequestParam("username") String name, @RequestParam("password") String password) {
        memberService.insertUser(name, password);
            return "註冊成功";
    }


    /*@Autowired
    private RegisterDao registerDao;

    @PostMapping("/register")
    public String create(@RequestBody MemberService memberService)throws Exception  {
        byte[] keyBytes = "0123456789abcdef".getBytes(); // 16字節的密鑰
        EncrypAES de1 = new EncrypAES(keyBytes);
        String msg = memberService.getPassword();
        byte[] encontent = de1.Encrytor(msg);
        memberService.setPassword(Base64.encodeBase64String(encontent));
        registerDao.insert(memberService);
        return "已註冊";
    }

    @GetMapping("/register/{account}")
    public String read(@PathVariable String account) {
        return "執行資料庫的 Read 操作";
    }
    @PutMapping("/register/{account}")
    public String update(@PathVariable String account,
                         @RequestBody MemberService user) {
        return "執行資料庫的 Update 操作";
    }
    @DeleteMapping("/register/{account}")
    public String delete(@PathVariable String account) {
        return "執行資料庫的 Delete 操作";
    }*/
}
