package com.dspt.interceptors;

import com.dspt.jwt.JWTconfig;
import com.dspt.util.JsonResult;
import org.springframework.context.ApplicationContext;
import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Logininterceptor implements HandlerInterceptor {

    @Override//预先处理， 最先执行
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        HttpSession session = request.getSession();
        String token = request.getHeader("token");
        if(token==null||!JWTconfig.checkToken(token)){
//            System.out.println("ssss");
            response.addHeader("error","pleasc login");
            return false;
        }
        else {
        String username= JWTconfig.gettokenUsername(token);
//        System.out.println("Login拦截器");
//        Object username=session.getAttribute("username");
//        Object user=session.getAttribute("user");
//        Object usered=session.getAttribute("usered");
        if((username==null)){
            response.addHeader("error","please login");
//            returnJson(response, new JsonResult(400,"请先登录",null));
            return false;
        }
        else {
            return true;
        }}
    }

    //返回客户端数据
//    private void returnJson(HttpServletResponse response,JsonResult json) throws Exception {
//        PrintWriter writer=null;
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("test/thml;charset=utf-8");
//        response.addHeader("aa","bb");
//        try {
//            writer=response.getWriter();
//            writer.print(json);
//        } catch (IOException e) {
//        }finally {
//            if (writer!=null)
//                writer.close();
//        }
//    }

    //      控制器代码执行完成后会进入此方法，当前方法执行完成之后开始响应
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    //响应后会执行此方法
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
