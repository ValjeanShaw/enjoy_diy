package com.lucky.exception;

import lombok.Data;

/**
 * @author 600006
 * @version 1.0
 */
@Data
public class ErrorInfo<T> {

    /**
     * 正确
     */
    public static final Integer OK = 0;
    /**
     * 错误
     */
    public static final Integer ERROR = 100;

    /**
     * 错误码
     */
    private Integer code;
    private String message;
    private String url;
    private T data;
}
