package com.xzw.payment.config;

import com.xzw.payment.interceptor.PaymentInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class PaymentConfiguration implements WebMvcConfigurer {

    @Autowired
    PaymentInterceptor paymentInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(paymentInterceptor).addPathPatterns("/**");
    }
}
