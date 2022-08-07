//package com.dspt.tools;
//
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//public class MyInterceptor implements HandlerInterceptor {
//    @Override//预先处理， 最先执行
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        System.out.println("=======1=======");
////        return HandlerInterceptor.super.preHandle(request, response, handler);
//         return false;
//    }
////      控制器代码执行完成后会进入此方法，当前方法执行完成之后开始响应
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        System.out.println("======3=======");
////        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
//    }
////响应后会执行此方法
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
////        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
//        System.out.println("==========4========= ");
//    }
//}
//
///*配置拦截器
//
// */