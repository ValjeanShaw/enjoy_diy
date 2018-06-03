package com.lucky.exception;

import lombok.Data;

/**
 * @author 600006
 * @version 1.0
 *
 * 自定义异常
 */
@Data
public class BaseException extends Exception {
    private Integer code;
    private String message;
    public BaseException(){

    }
    public BaseException(String message){
        super(message);
    }

    public BaseException(Integer code,String message){
        super();
        this.code = code;
        this.message = message;
    }
}
