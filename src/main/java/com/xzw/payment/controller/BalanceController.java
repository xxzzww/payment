package com.xzw.payment.controller;

import com.xzw.payment.config.Result;
import com.xzw.payment.entity.BalanceLogEntity;
import com.xzw.payment.exception.ECodeEnume;
import com.xzw.payment.service.BalanceLogService;
import com.xzw.payment.service.BalanceService;
import com.xzw.payment.vo.BalanceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;


/**
 * 余额操作类接口
 */
@RestController
@RequestMapping("payment/balance")
public class BalanceController {
    @Autowired
    private BalanceService balanceService;

    /**
     * 查询用户钱包余额
     */
    @GetMapping("/queryBalance")
    public Result queryBalance(){
        BigDecimal balance = balanceService.getBalance();
        return Result.ok(balance);
    }
    /**
     * 用户消费接口
     */
    @PostMapping("/consumption")
    public Result consumption(BalanceVo balanceVo){
        ECodeEnume code = balanceService.consumption(balanceVo);
        if (code.getCode()==ECodeEnume.SUCCESS.getCode()){
//            消费成功
            return Result.ok("消费成功");
        }
//        消费失败
        return  Result.error(code);
    }
    /**
     * 用户退款接口
     */
    @PostMapping("/refund")
    public Result refund(BalanceVo balanceVo){
        ECodeEnume code = balanceService.refund(balanceVo);
        if (code.getCode()==ECodeEnume.SUCCESS.getCode()){
//            退款成功
            return Result.ok("退款成功");
        }
//        退款失败
        return  Result.error(code);
    }
}
