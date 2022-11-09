package com.xzw.payment.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName("balance_log")
public class BalanceLogEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId(value = "id")
	private Long id;
	/**
	 * 用户id
	 */
	private Long userid;
	/**
	 * 修改金额
	 */
	private BigDecimal money;
	/**
	 * 修改类型，1支付2收入
	 */
	private Integer type;
	/**
	 * 备注
	 */
	private String remarks;

}
