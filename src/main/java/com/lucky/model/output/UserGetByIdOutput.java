package com.lucky.model.output;

import lombok.Data;

/**
 * @author 600006
 * @version 1.0
 */
@Data
public class UserGetByIdOutput {
    private Long userId;
    private String username;
    private String email;
    private String mobile;
    private Long updateTime;
}
