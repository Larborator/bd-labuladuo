package com.douyu.bd.labuladuo.core.enums;

/**
 * @author labuladuo
 */
public enum ResultCodeEnum {
    /**
     * 请求成功
     */
    SUCCESS(0, "请求成功"),
    /**
     * 请求失败
     */
    ERROR(1, "请求失败"),
    /**
     * 请求失败，并写出失败信息
     */
    ERROR_WITH_MSG(1, "%s"),
    ;

    private final int code;
    private final String msg;

    ResultCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
