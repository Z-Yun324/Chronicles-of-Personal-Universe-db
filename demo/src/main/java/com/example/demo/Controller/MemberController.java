package com.example.demo.Controller;
import com.example.demo.Dao.LoginDao;
import com.example.demo.Dao.RegisterDao;
import com.example.demo.utils.EncrypAES;
import com.example.demo.pojo.Member;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MemberController {
    @Autowired
    private RegisterDao registerDao;
    @Autowired
    private LoginDao loginDao;

    @PostMapping("/register")
    public String create(@RequestBody Member member)throws Exception  {
        byte[] keyBytes = "0123456789abcdef".getBytes(); // 16字節的密鑰
        EncrypAES de1 = new EncrypAES(keyBytes);
        String msg = member.getPassword();
        byte[] encontent = de1.Encrytor(msg);
        member.setPassword(Base64.encodeBase64String(encontent));
        registerDao.insert(member);
        return "已註冊";
    }

    @GetMapping("/register/{account}")
    public String read(@PathVariable String account) {
        return "執行資料庫的 Read 操作";
    }
    @PutMapping("/register/{account}")
    public String update(@PathVariable String account,
                         @RequestBody Member user) {
        return "執行資料庫的 Update 操作";
    }
    @DeleteMapping("/register/{account}")
    public String delete(@PathVariable String account) {
        return "執行資料庫的 Delete 操作";
    }


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Member member) throws Exception {
        if(loginDao.isValidUser(member.getAccount(), member.getPassword())){
            return ResponseEntity.ok("登入成功");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("登入失敗");
        }
    }
}