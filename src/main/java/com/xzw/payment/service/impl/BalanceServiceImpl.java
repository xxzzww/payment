package com.xzw.payment.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzw.payment.dao.BalanceDao;
import com.xzw.payment.entity.BalanceEntity;
import com.xzw.payment.entity.BalanceLogEntity;
import com.xzw.payment.exception.ECodeEnume;
import com.xzw.payment.interceptor.PaymentInterceptor;
import com.xzw.payment.service.BalanceLogService;
import com.xzw.payment.service.BalanceService;
import com.xzw.payment.vo.BalanceVo;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class BalanceServiceImpl extends ServiceImpl<BalanceDao, BalanceEntity> implements BalanceService {

    @Resource
    RedissonClient redissonClient;
    @Resource
    BalanceLogService balanceLogService;
    private final String balance="balance:";
    //  用户查询余额
    @Override
    public BigDecimal getBalance() {
//        从ThreadLocal获取用户id
        Long userid = PaymentInterceptor.USERID.get();
        BalanceEntity balanceEntity = this.getById(userid);

        return balanceEntity.getBalance();
    }

    //  用户消费
    @Transactional
    @Override
    public ECodeEnume consumption(BalanceVo balanceVo) {
//        从ThreadLocal获取用户id
        Long userid = PaymentInterceptor.USERID.get();
        RLock rlock = redissonClient.getLock(balance+userid);
//        金额向上取整2位
        balanceVo.setBalance(balanceVo.getBalance().setScale(2, BigDecimal.ROUND_UP));
        try {
            //根据用户id设置默认的分布式锁
            rlock.lock();
//            查询用户余额
            BalanceEntity balanceEntity = this.getById(userid);
            log.info("用户:{}，余额:{}，消费金额:{},备注:{}",userid,balanceEntity.getBalance(),balanceVo.getBalance(),balanceVo.getRemarks());
//            用户余额大于要消费的余额  当前余额-修改的余额>=0
            if (balanceEntity.getBalance().compareTo(balanceVo.getBalance())!= -1){
//              添加消费记录
                BalanceLogEntity logEntity = new BalanceLogEntity();
                logEntity.setUserid(userid);
                logEntity.setMoney(balanceVo.getBalance());
                logEntity.setRemarks(balanceVo.getRemarks());
                logEntity.setType(1);
                balanceLogService.save(logEntity);
//              修改用户金额 当前余额-修改的余额
                balanceEntity.setBalance(balanceEntity.getBalance().subtract(balanceVo.getBalance()));
                this.updateById(balanceEntity);
                log.info("用户:{}，消费{}元成功，余额:{}",userid,balanceVo.getBalance(),balanceEntity.getBalance());
                return ECodeEnume.SUCCESS;
            }
            else {
                log.info("用户{}用户余额不足",userid);
                return ECodeEnume.NOT_BALANCE;
            }
        } finally {
            rlock.unlock();
        }
    }

    //  用户退款
    @Transactional
    @Override
    public ECodeEnume refund(BalanceVo balanceVo) {
//        从ThreadLocal获取用户id
        Long userid = PaymentInterceptor.USERID.get();
        RLock rlock = redissonClient.getLock(balance+userid);
//        金额向上取整2位
        balanceVo.setBalance(balanceVo.getBalance().setScale(2, BigDecimal.ROUND_UP));
        try {
            //根据用户id设置默认的分布式锁
            rlock.lock();
//          查询用户余额信息
            BalanceEntity balanceEntity = this.getById(userid);
            log.info("用户:{}，余额:{}，退款金额:{},备注:{}",userid,balanceEntity.getBalance(),balanceVo.getBalance(),balanceVo.getRemarks());
//          添加退款记录
            BalanceLogEntity logEntity = new BalanceLogEntity();
            logEntity.setUserid(userid);
            logEntity.setMoney(balanceVo.getBalance());
            logEntity.setRemarks(balanceVo.getRemarks());
            logEntity.setType(2);
            balanceLogService.save(logEntity);
//              修改用户金额 当前余额+修改的余额
            balanceEntity.setBalance(balanceEntity.getBalance().add(balanceVo.getBalance()));
            this.updateById(balanceEntity);
            log.info("用户:{}，退款{}元成功，余额:{}",userid,balanceVo.getBalance(),balanceEntity.getBalance());
            return ECodeEnume.SUCCESS;
        } finally {
            rlock.unlock();
        }
    }

}
