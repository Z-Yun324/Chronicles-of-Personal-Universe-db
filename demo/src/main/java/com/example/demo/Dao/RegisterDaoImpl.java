package com.example.demo.Dao;

import com.example.demo.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class RegisterDaoImpl implements RegisterDao {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public String insert(MemberService user) {
        String sql = "INSERT INTO test(account, password) VALUES (:account, :password)";
        Map<String, Object> map = new HashMap<>();
        map.put("account", user.getAccount());
        map.put("password", user.getPassword());
        namedParameterJdbcTemplate.update(sql, map);
        return "已註冊";
    }
}
