package com.xzw.payment.exception;


import com.xzw.payment.config.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/*
 *异常处理类
 */
@Slf4j
@RestControllerAdvice(basePackages = "com.ymw.controller")
public class ControllerException {
    @ExceptionHandler(value = Exception.class)
    public Result exception(Exception e){
        log.error("未知异常：{}，异常类型：{}",e.getMessage(),e.getClass());
        e.printStackTrace();
        return Result.error(ECodeEnume.UNKNOWN.getCode(),ECodeEnume.UNKNOWN.getMsg());
    }
}
