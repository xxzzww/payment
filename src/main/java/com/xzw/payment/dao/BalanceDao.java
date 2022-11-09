package com.xzw.payment.dao;

import com.xzw.payment.entity.BalanceEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

@Mapper
public interface BalanceDao extends BaseMapper<BalanceEntity> {

    int updateConsumption(@Param("userid") Long userid, @Param("balance") BigDecimal balance);
}
