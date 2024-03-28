package com.example.demo.Dao;

/*@Repository
public class RegisterDaoImpl implements RegisterDao {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public String insert(Member user) {
        String sql = "INSERT INTO test(account, password) VALUES (:account, :password)";
        Map<String, Object> map = new HashMap<>();
        map.put("account", user.getAccount());
        map.put("password", user.getPassword());
        namedParameterJdbcTemplate.update(sql, map);
        return "已註冊";
    }
}*/
