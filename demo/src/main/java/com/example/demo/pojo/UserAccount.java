package com.example.demo.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
public class UserAccount {
    private int user_id;
    private String user_password;
    private String user_name;
    private String user_nickname;
    private String email;
    private PictureID pictureID;
    private String salt;

}
