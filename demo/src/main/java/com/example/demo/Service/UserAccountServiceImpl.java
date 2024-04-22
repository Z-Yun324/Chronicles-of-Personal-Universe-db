package com.example.demo.Service;

import com.example.demo.mapper.UserAccountMapper;
import com.example.demo.pojo.UserAccount;
import com.example.demo.utils.EncrypAES;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserAccountServiceImpl implements UserAccoutService{
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private UserAccountMapper mapper;

    public UserAccountServiceImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate, UserAccountMapper mapper) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.mapper = mapper;
    }

    public boolean isValidUser(String account, String password)throws Exception{
        String sql = "SELECT user_password FROM user_account WHERE user_name = :account LIMIT 1";
        Map<String ,Object> paramMap = new HashMap<>();
        paramMap.put("account",account);
        String encryptedPassword = namedParameterJdbcTemplate.queryForObject(sql,paramMap,String.class);
        byte[] keyBytes = "0123456789abcdef".getBytes(); // 16字節的密鑰
        EncrypAES de1 = new EncrypAES(keyBytes);
        byte[] decontent = de1.Decryptor(Base64.decodeBase64(encryptedPassword));
        String decryptedPassword = new String(decontent);
        return password.equals(decryptedPassword);
    }
    public boolean insertUser(String username, String password) {
        // 調用 Mapper 接口中的 insertUser 方法向數據庫中插入新用戶
        int rowsAffected = mapper.insertUser(username, password);
        // 返回插入操作是否成功
        return rowsAffected > 0;
    }

    @Override
    public UserAccount getUserByNameAndPassword(String username, String password) {
        return mapper.getUserByNameAndPassword(username, password);
    }

    //------------------------------------------------------------------

    /*
    @Autowired
    private UserAccoutService userAccoutService;
    private String getMd5Password(String password, String salt) {
        // 對password + salt 進行三次加密
        String str = password + salt;
        for (int i = 0; i < 3; i++) {
            str = DigestUtils.md5DigestAsHex(str.getBytes()).toUpperCase();
        }
        return str;
    }
    @Override
    public UserAccount login(UserAccount userAccount) {
        // TODO Auto-generated method stub
        // 檢查帳號是否存在
        UserAccount data = userAccountDao.findUserAccountByUsername(userAccount.getUsername());
        if(data == null) return null;

        // 使用資料庫鹽值對輸入密碼進行加密
        String md5Password = getMd5Password(memberAccount.getPassword(), data.getSalt());

        // 比對密碼是否相等
        if(!md5Password.equals(data.getPassword())) return null;

        // 取得對應Member 資料
        Member member = memberService.findMemberByMa_id(data.getId());
        if(member == null) return null;
    }

    @Override
    public Optional<String> register(MemberAccountVO memberAccountVO) {

        // TODO Auto-generated method stub
        // 驗證欄位是否填寫及格式
        if(!ValidFormat.isEmail(memberAccountVO.getUsername())) return Optional.of("帳號必須是Email 格式");
        if(!ValidFormat.isPassword(memberAccountVO.getPassword())) return Optional.of("密碼必須為長度6~16位碼大小寫英文加數字");
        if(!memberAccountVO.getPassword().equals(memberAccountVO.getCheckPassword())) return Optional.of("兩次輸入密碼不相符");

        // 檢查帳號是否重複註冊
        UserAccount data = userAccountDao.findUserAccountByUsername(memberAccountVO.getUsername());
        if(data != null) return Optional.of("該帳號已被使用");

        // 產生鹽值
        String salt = UUID.randomUUID().toString().toUpperCase().replaceAll("-", "");

        // 密碼加密
        String md5Password = getMd5Password(memberAccountVO.getPassword(), salt);

        // 新增MemberAccount 資料
        UserAccount userAccount = new UserAccount();
        userAccount.setUser_name();
        userAccount.setUser_password(md5Password);
        userAccount.setSalt(salt);
        Integer id = userAccountDao.insert(memberAccount);
        if(id == 0) return Optional.of("新增會員帳號時發生錯誤");

        // 新增Member 資料
        Member member = new Member();
        member.setMa_id(String.valueOf(id));
        member.setName(memberAccountVO.getName());
        member.setCreate_by(memberAccountVO.getUsername());
        member.setUpdate_by(memberAccountVO.getUsername());
        Integer result = userAccountDao.insert((UserAccount) member);
        if(result == 0) return Optional.of("新增會員資料時發生錯誤");

        return Optional.empty();
    }

    @Override
    public UserAccount getUserByNameAndPassword(String username, String password) {
        return null;
    }

    @Override
    public boolean insertUser(String username, String password) {
        return false;
    }

    @Override
    public UserAccount findUserAccountByUsername(String username) {
        // TODO Auto-generated method stub
        return userAccountDao.findUserAccountByUsername(username);
    }*/
}
