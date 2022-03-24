package com.douyu.bd.labuladuo.core.exception;

import java.io.Serializable;

/**
 * 自定义业务异常
 *
 * @author labuladuo
 * @date 2021-11-12
 **/
public class RangerClientException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = -4441189815976639860L;
    private final int status;
    private final String message;

    public RangerClientException(int status, String message) {
        this.status = status;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return String.format("%s http status = %s", message, status);
    }

    @Override
    public String toString() {
        return String.format("%s http status = %s", message, status);
    }
}
