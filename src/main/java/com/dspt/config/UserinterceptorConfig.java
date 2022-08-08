package com.dspt.config;

import com.dspt.interceptors.Logininterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class UserinterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new Logininterceptor())//添加拦截器
                .addPathPatterns("/**")//添加拦截请求路径
                .excludePathPatterns("/per/login")
                .excludePathPatterns("/register/getmenu");//添加哪些路径不经过拦截器


    }
}
