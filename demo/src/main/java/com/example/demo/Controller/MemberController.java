package com.example.demo.Controller;
/*
import com.example.demo.Dao.LoginDao;
import com.example.demo.Dao.RegisterDao;
import com.example.demo.Service.LoginService;
import com.example.demo.Service.MemberService;
import com.example.demo.pojo.UserAccount;
import com.example.demo.utils.EncrypAES;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MemberController {
    @Autowired
    private LoginService loginService;

    @Autowired
    private RegisterDao registerDao;
    @Autowired
    private MemberService memberService;

    @PostMapping("/register")
    public String register(@RequestParam("username") String name, @RequestParam("password") String password)throws Exception {
        byte[] keyBytes = "0123456789abcdef".getBytes(); // 16字節的密鑰
        EncrypAES de1 = new EncrypAES(keyBytes);
        String msg = memberService.getPassword();
        byte[] encontent = de1.Encrytor(msg);
        memberService.setPassword(Base64.encodeBase64String(encontent));
        memberService.in
            return "註冊成功";
    }
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
    @PostMapping("/login")
    public String login(@RequestParam("username") String name,@RequestParam("password") String password){
        UserAccount user = loginService.getUserByNameAndPassword(name,password);
        if(user != null){
            return "登入成功";
        } else{
            return "登入失敗";
        }
    }

    @Autowired
    private LoginDao loginService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody MemberService memberService) throws Exception {
        if(loginService.isValidUser(memberService.getAccount(),memberService.getPassword())){
            return ResponseEntity.ok("登入成功");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("登入失敗");
        }
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
    }
}*/
