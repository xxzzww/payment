package com.xzw.payment.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xzw.payment.entity.BalanceEntity;
import com.xzw.payment.entity.BalanceLogEntity;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface BalanceLogDao extends BaseMapper<BalanceLogEntity> {
	
}
