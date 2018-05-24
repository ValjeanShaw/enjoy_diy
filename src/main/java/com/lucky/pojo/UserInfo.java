package com.lucky.pojo;

import lombok.Data;

/**
 * @author 600006
 * @version 1.0
 */
@Data
public class UserInfo {
    private Long userId;
    private String username;
    private String password;
    private String email;
    private String mobile;
    private Long updateTime;
}
