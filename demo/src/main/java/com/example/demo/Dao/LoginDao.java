package com.example.demo.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public boolean isValidUser(String account, String password){
        String sql = "SELECT COUNT(*) FROM test WHERE account = :account AND password = :password";
        Map<String ,Object> paramMap = new HashMap<>();
        paramMap.put("account",account);
        paramMap.put("password",password);

        int count = namedParameterJdbcTemplate.queryForObject(sql,paramMap,Integer.class);

        return count == 1;
    }
}
