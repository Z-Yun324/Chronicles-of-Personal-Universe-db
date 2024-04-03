package com.example.demo.Dao;

import com.example.demo.pojo.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UserAccountDaoImpl implements UserAccountDao{
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate jdbcNameTemplate;
    @Autowired
    public UserAccountDaoImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate jdbcNameTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.jdbcNameTemplate = jdbcNameTemplate;
    }


    @Override
    public Integer insert(UserAccount userAccount) {
        String sql = "INSERT INTO user_account (user_id, user_password, user_name, user_nickname, email, pictureID, salt, create_by, create_time, update_by, update_time) " +
                "VALUES (:user_id, :user_password, :user_name, :user_nickname, :email, :pictureID, :salt, :create_by, NOW(), :update_by, NOW())";

        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(userAccount);
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcNameTemplate.update(sql, paramSource, keyHolder);
        return keyHolder.getKey().intValue();
    }

    @Override
    public UserAccount findUserAccountByUsername(String username) {
        String sql = "SELECT user_id, user_password, user_name, user_nickname, email, pictureID, salt " +
                "FROM user_account " +
                "WHERE user_name = ?";

        List<UserAccount> result = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(UserAccount.class), username);
        return result.isEmpty() ? null : result.get(0);
    }

    @Override
    public Integer update(UserAccount userAccount) {
        String sql = "UPDATE user_account " +
                "SET user_password = :user_password, update_by = :update_by, update_time = NOW() " +
                "WHERE user_id = :user_id";

        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(userAccount);
        return jdbcNameTemplate.update(sql, paramSource);
    }
}
