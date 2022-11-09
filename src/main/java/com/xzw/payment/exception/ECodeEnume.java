package com.xzw.payment.exception;
/**
 * 用户异常枚举
 * @author Ren
 * @date 2022/10/19
 * @return
 */
public enum ECodeEnume {
    SUCCESS(200,"成功"),
    NOT_BALANCE(100001,"余额不足"),
    UNKNOWN(000000,"未知异常，请联系管理人员")
    ;
    private int code;
    private String msg;

    ECodeEnume(int code, String msg) {
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
