//package com.dspt.tools;
//
//import com.dspt.entity.User;
//import com.dspt.jwt.Creattoken;
//import com.dspt.service.Userservice;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.util.HashMap;
//import java.util.Map;
//
//@RestController
//@RequestMapping
//public class Logincontroller {
//    //尝试jwt
//    @Autowired
//    Userservice userservice;
//    @RequestMapping("/per/login")
//    public Object aa(@RequestBody User user, HttpServletRequest request, HttpServletResponse response) {
//        HttpSession session = request.getSession();
////        List<User> users = userservice.findall();
//        System.out.println(user.toString());
//        User findone = userservice.findone(user.getUsername());
////          User findone = userservice.findone(user);
//        Map<String,Object> map=new HashMap<>();
//        if (findone == null) {
////            session.setAttribute("usered", "登录失败");//用户，用户名，状态放入session
//            return map.put("登录状态","登录失败");
//        } else {
//            if (findone.getPassword().equals(user.getPassword())) {
////                session.setAttribute("user", user);
////                session.setAttribute("username",user.getUsername());
////                System.out.println(session.getAttribute("user") + "session");
////                Cookie cookie = new Cookie("username", user.getUsername());
////                cookie.setMaxAge(60 * 60 * 24 * 7);
////                response.addCookie(cookie);
//                String token= Creattoken.gettoken(user);
//                if (user.getUsername().equals("root")) {
//                    map.put("token",token);
//                    map.put("登录状态","管理员登陆成功");
////                    Cookie cookie1 = new Cookie("state", "1");
////                    cookie1.setMaxAge(60 * 60 * 24 * 7);
////                    response.addCookie(cookie1);
////                    session.setAttribute("usered", "管理员登录成功");//usered:是否登陆成功
//                    return map;
//                } else {
////                    Cookie cookie0 = new Cookie("state", "0");
////                    cookie0.setMaxAge(60 * 60 * 24 * 7);
////                    response.addCookie(cookie0);
////                    session.setAttribute("usered", "用户登录成功");
//                    map.put("token",token);
//                    map.put("登录状态","管理员登陆成功");
//                    return map;
//                }
//            } else {
////                session.setAttribute("usered", "登录失败");
//                     map.put("登录状态","登录失败");
//                     return map;
//            }
//        }
////        return session.getAttribute("usered");
//    }
//}
