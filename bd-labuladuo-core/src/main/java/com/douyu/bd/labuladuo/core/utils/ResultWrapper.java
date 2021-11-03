package com.douyu.bd.labuladuo.core.utils;

import static com.douyu.bd.labuladuo.core.enums.ResultCodeEnum.*;

/**
 * @author labuladuo
 */
public class ResultWrapper<T> {
    private int code;
    private String msg;
    private T data;

    public ResultWrapper() {
    }

    public ResultWrapper(int code) {
        this.code = code;
    }

    public ResultWrapper(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultWrapper(int code, T data) {
        this.code = code;
        this.data = data;
    }

    public ResultWrapper(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <E> ResultWrapper<E> asOk() {
        return new ResultWrapper<>(SUCCESS.getCode());
    }

    public static <E> ResultWrapper<E> asOk(E data) {
        return new ResultWrapper<>(SUCCESS.getCode(), data);
    }

    public static <E> ResultWrapper<E> asError() {
        return new ResultWrapper<>(ERROR.getCode(), ERROR.getMsg());
    }

    public static <E> ResultWrapper<E> asError(String msg) {
        return new ResultWrapper<>(ERROR.getCode(), msg);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
