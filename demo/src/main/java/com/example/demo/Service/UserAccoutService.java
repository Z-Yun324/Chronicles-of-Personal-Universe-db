package com.example.demo.Service;

import com.example.demo.pojo.UserAccount;

public interface UserAccoutService {

    // 業務邏輯
    //public UserAccount login(UserAccount userAccount);
    public UserAccount getUserByNameAndPassword(String username, String password);

    // 資料庫操作
    //public UserAccount findUserAccountByUsername(String username);
}
