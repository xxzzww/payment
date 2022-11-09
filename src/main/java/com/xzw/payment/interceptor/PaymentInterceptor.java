package com.xzw.payment.interceptor;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//拦截器
// 如果是单体项目可以把session直接存放在本地，
// 如果是微服务可以使用spring session把session存放到redis里面，多个服务共享session

@Component
public class PaymentInterceptor implements HandlerInterceptor {
//这里简单存放用户id，如果需要也可以存放用户信息user类或者token
    public static ThreadLocal<Long> USERID = new ThreadLocal<>();

    //    方法执行前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断用户是否登录了
        Long userId = (Long) request.getSession().getAttribute("userid");
        if (userId != null) {
            //如果用户已经登录了，放在ThreadLocal里面，方便service调用
            USERID.set(userId);
            return true;
        } else {
            //未登录就跳转登录页
//            request.getSession().setAttribute("msg", "请先登录");
//            response.sendRedirect("跳转到登录页面");
//            return false;
            //这里为了测试绑定一个用户1
            USERID.set(1L);
            return true;
        }
    }
    //方法执行后
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
//        清除ThreadLocal
        USERID.remove();
    }
}
