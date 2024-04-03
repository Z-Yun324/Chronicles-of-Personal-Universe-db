package com.example.demo.Dao;

import com.example.demo.pojo.UserAccount;

public interface UserAccountDao {
    public Integer insert(UserAccount userAccount);
    public UserAccount findUserAccountByUsername(String username);
    public Integer update(UserAccount userAccount);
}
