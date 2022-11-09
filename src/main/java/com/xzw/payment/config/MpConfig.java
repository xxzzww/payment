package com.xzw.payment.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MybatisPlus分页拦截器
 */
@Configuration
public class MpConfig {
    @Bean
    public MybatisPlusInterceptor mp(){
        //1.定义Mp拦截器
        MybatisPlusInterceptor mp=new MybatisPlusInterceptor();
        //2.添加具体的拦截器
        mp.addInnerInterceptor(new PaginationInnerInterceptor());
        return mp;
    }
}
