package com.example.demo.Controller;

import com.example.demo.Service.UserAccountServiceImpl;
import com.example.demo.pojo.UserAccount;
import com.example.demo.utils.EncrypAES;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAccountController {
    private UserAccountServiceImpl userAccountServiceImpl;
    private UserAccount userAccount;
    public UserAccountController(UserAccountServiceImpl userAccountServiceImpl) {
        this.userAccountServiceImpl = userAccountServiceImpl;
        this.userAccount = new UserAccount();
    }

    //-----------------------------------------------------------------------
    @PostMapping("/login")
    public String login(@RequestParam("username") String name, @RequestParam("password") String password) throws Exception {
        if (userAccountServiceImpl.isValidUser(name, password)) {
            return "登入成功";
        } else {
            return "登入失敗";
        }
    }

        //-----------------------------------------------------------------------
        @PostMapping("/register")
        public String register(@RequestParam("username") String username, @RequestParam("password") String password)throws Exception {
            byte[] keyBytes = "0123456789abcdef".getBytes(); // 16字節的密鑰
            EncrypAES de1 = new EncrypAES(keyBytes);
            byte[] encontent = de1.Encrytor(password);
            userAccountServiceImpl.insertUser(username,Base64.encodeBase64String(encontent));
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

