package com.xzw.payment.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;
@Data
@TableName("balance")
public class BalanceEntity implements Serializable {
	private static final long serialVersionUID = 1L;
//	用户id
	@TableId
	private Long userid;
//	用户余额
	private BigDecimal balance;

}
