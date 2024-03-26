package com.example.demo.Service;

import com.example.demo.mapper.Mapper;
import com.example.demo.pojo.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    /*String account;
    String password;
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }*/

    @Autowired
    private Mapper mapper;

    public UserAccount insertUser(String name, String password) {
        return mapper.insertUser(name, password);
    }

    private boolean isUserNameExists(String name){
        int count = mapper.checkUserNameExists(name);
        return count > 0;
    }

}
