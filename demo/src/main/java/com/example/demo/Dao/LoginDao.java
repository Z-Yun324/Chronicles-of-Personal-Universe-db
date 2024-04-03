package com.example.demo.Dao;
/*
import com.example.demo.utils.EncrypAES;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    /*public boolean isValidUser(String account, String password){
        String sql = "SELECT COUNT(*) FROM test WHERE account = :account AND password = :password";
        Map<String ,Object> paramMap = new HashMap<>();
        paramMap.put("account",account);
        paramMap.put("password",password);

        int count = namedParameterJdbcTemplate.queryForObject(sql,paramMap,Integer.class);

        return count == 1;
    }
    public boolean isValidUser(String account, String password)throws Exception{
        String sql = "SELECT password FROM test WHERE account = :account LIMIT 1";
        Map<String ,Object> paramMap = new HashMap<>();
        paramMap.put("account",account);
        String encryptedPassword = namedParameterJdbcTemplate.queryForObject(sql,paramMap,String.class);
        byte[] keyBytes = "0123456789abcdef".getBytes(); // 16字節的密鑰
        EncrypAES de1 = new EncrypAES(keyBytes);
        byte[] decontent = de1.Decryptor(Base64.decodeBase64(encryptedPassword));
        String decryptedPassword = new String(decontent);
        return password.equals(decryptedPassword);
    }
}*/
