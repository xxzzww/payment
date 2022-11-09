package com.xzw.payment.vo;

import lombok.Data;

import java.math.BigDecimal;
//接收前端传递的修改金额信息
@Data
public class BalanceVo {
    //用户要消费/退款余额
    private BigDecimal balance;
    //用户备注
    private String remarks;
}
