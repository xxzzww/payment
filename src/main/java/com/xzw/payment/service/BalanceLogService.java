package com.xzw.payment.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xzw.payment.entity.BalanceLogEntity;
import com.xzw.payment.vo.BalanceLogVo;
import com.xzw.payment.vo.PageVo;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author xiong
 * @email xzw@qq.com
 * @date 2022-07-23 22:12:04
 */
public interface BalanceLogService extends IService<BalanceLogEntity> {
//  查询用户钱包金额变动明细
    Page<BalanceLogEntity> listById(BalanceLogVo balanceLogVo);
}

