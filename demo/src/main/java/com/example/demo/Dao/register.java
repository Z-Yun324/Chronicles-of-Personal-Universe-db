package com.example.demo.Dao;

import com.example.demo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class register {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public String insert(@RequestBody User user){
        String sql = "INSERT INTO test(account, password) VALUES (:account, :password)";
        Map<String, Object> map = new HashMap<>();
        map.put("account", user.getAccount());
        map.put("password", user.getPassword());
        namedParameterJdbcTemplate.update(sql, map);
        return "已註冊";
    }
}
