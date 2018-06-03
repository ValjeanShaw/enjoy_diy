package com.lucky.model;

import lombok.Data;

/**
 * @author 600006
 * @version 1.0
 */
@Data
public class ResultModel<T> {
    private Integer code;
    private String message;
    private T data;
}
