package com.example.demo.mapper;

import com.example.demo.pojo.UserAccount;

@org.apache.ibatis.annotations.Mapper
public interface UserAccountMapper {

    UserAccount getUserByNameAndPassword(String userName, String password);
    int insertUser(String userName,String password,String nickName,String email);
    UserAccount findUserAccountByUserName(String userName);
}


