package com.xzw.payment.config;

import com.xzw.payment.exception.ECodeEnume;
import lombok.Data;

import java.io.Serializable;

/**
 * 全局统一返回结果类
 */
@Data
public class Result<T> implements Serializable {
    //返回码
    private Integer code;
    //返回消息
    private String message;
    //返回数据
    private T data;

    public Result() {
    }

    /**
     * 成功
     */
    public static <T> Result<T> ok(T data) {
        Result<T> result = new Result<>();
        result.code = 200;
        result.message = "ok";
        result.data = data;
        return result;
    }

    /**
     * 失败
     */
    public static <T> Result<T> error() {
        Result<T> result = new Result<>();
        result.code = 500;
        result.message = "error";
        return result;
    }

    /**
     * 失败重载，自定义失败信息
     */
    public static <T> Result<T> error(int code, String message) {
        Result<T> result = new Result<>();
        result.code = code;
        result.message = message;
        return result;
    }

    public static <T> Result<T> error(ECodeEnume codeEnume) {
        Result<T> result = new Result<>();
        result.code = codeEnume.getCode();
        result.message = codeEnume.getMsg();
        return result;
    }
    public static <T> Result<T> put(ECodeEnume codeEnume) {
        Result<T> result = new Result<>();
        result.code = codeEnume.getCode();
        result.message = codeEnume.getMsg();
        return result;
    }
}
