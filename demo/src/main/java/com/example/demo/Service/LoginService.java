package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginService {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public boolean isValidUser(String username, String password){
        String sql = "SELECT COUNT(*) FROM test2 WHERE username = : username AND password = :password";
        Map<String ,Object> paramMap = new HashMap<>();
        paramMap.put("username",username);
        paramMap.put("password",password);

        int count = namedParameterJdbcTemplate.queryForObject(sql,paramMap,Integer.class);

        return count == 1;
    }
}
