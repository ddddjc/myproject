package com.dspt.interceptors;

import com.dspt.jwt.JWTconfig;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Logininterceptor implements HandlerInterceptor {
    @Override//预先处理， 最先执行
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        HttpSession session = request.getSession();
        String token = request.getHeader("token");
        if(token==null){
            return false;
        }
        else {
        String username= JWTconfig.gettokenUsername(token);
        System.out.println("Login拦截器");
//        Object username=session.getAttribute("username");
//        Object user=session.getAttribute("user");

//        Object usered=session.getAttribute("usered");
        if((username==null)){
            return false;
        }
        else {
            return true;
        }}
    }
    //      控制器代码执行完成后会进入此方法，当前方法执行完成之后开始响应
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    //响应后会执行此方法
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
