package com.example.demo.mapper;

import com.example.demo.pojo.UserAccount;

@org.apache.ibatis.annotations.Mapper
public interface Mapper {

    UserAccount getUserByNameAndPassword(String username, String password);
    int insertUser(String username,String password);
}


