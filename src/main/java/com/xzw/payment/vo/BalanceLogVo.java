package com.xzw.payment.vo;

import lombok.Data;

import java.math.BigDecimal;

//接收前端传递的修改金额信息
@Data
public class BalanceLogVo extends PageVo {
    //    支付类型：1支付，2退款
    private Integer type;
}
