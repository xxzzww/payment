package com.xzw.payment.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzw.payment.dao.BalanceLogDao;
import com.xzw.payment.entity.BalanceLogEntity;
import com.xzw.payment.interceptor.PaymentInterceptor;
import com.xzw.payment.service.BalanceLogService;
import com.xzw.payment.vo.BalanceLogVo;
import com.xzw.payment.vo.PageVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BalanceLogServiceImpl extends ServiceImpl<BalanceLogDao, BalanceLogEntity> implements BalanceLogService {
    //    查询用户钱包金额变动明细
    @Override
    public Page<BalanceLogEntity> listById(BalanceLogVo balanceLogVo) {
//        从ThreadLocal获取用户id
        Long userid = PaymentInterceptor.USERID.get();
        LambdaQueryWrapper<BalanceLogEntity> queryWrapper = new LambdaQueryWrapper<>();
//        获取除了用户id的其他信息
        queryWrapper.select(BalanceLogEntity::getMoney, BalanceLogEntity::getRemarks,
                BalanceLogEntity::getType, BalanceLogEntity::getUserid);
//        根据用户id获取信息
        queryWrapper.eq(BalanceLogEntity::getUserid, userid);
//        如果前端需要根据支付类型查找
        queryWrapper.eq(balanceLogVo.getType() != null, BalanceLogEntity::getType, balanceLogVo.getType());
//          分页
        Page<BalanceLogEntity> pageInfo = new Page<>(balanceLogVo.getPageNo(), balanceLogVo.getPageSize());
        this.page(pageInfo, queryWrapper);
        return pageInfo;
    }
}

