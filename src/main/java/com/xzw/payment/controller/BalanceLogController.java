package com.xzw.payment.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xzw.payment.config.Result;
import com.xzw.payment.entity.BalanceLogEntity;
import com.xzw.payment.service.BalanceLogService;
import com.xzw.payment.vo.BalanceLogVo;
import com.xzw.payment.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/*
 *余额日志操作类接口
 */

@RestController
@RequestMapping("/payment/balanceLog")
public class BalanceLogController {
    @Autowired
    private BalanceLogService balanceLogService;

    /**
     * 查询用户钱包金额变动明细
     * 参数：
     * type=页码默认1
     * pageNo=页数默认10
     * pageSize=支付类型默认无
     * 都是可选值
     */
    @GetMapping("/list")
    public Result list(BalanceLogVo balanceLogVo) {
        Page<BalanceLogEntity> logEntities = balanceLogService.listById(balanceLogVo);
        return Result.ok(logEntities);
    }
}
