package com.xzw.payment.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xzw.payment.entity.BalanceEntity;
import com.xzw.payment.exception.ECodeEnume;
import com.xzw.payment.vo.BalanceVo;

import java.math.BigDecimal;

/**
 * 
 *
 * @author xiong
 * @email xzw@qq.com
 * @date 2022-07-23 22:12:04
 */
public interface BalanceService extends IService<BalanceEntity> {

//  用户查询余额
    BigDecimal getBalance();
//  用户消费
    ECodeEnume consumption(BalanceVo balanceVo);
//  用户退款
ECodeEnume refund(BalanceVo balanceVo);
}

