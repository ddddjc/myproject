//package com.dspt.tools;
//
//import com.dspt.entity.User;
//import com.dspt.service.Userservice;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//public class Usercontroller {
//    @Autowired
//    Userservice userservice;
//
//    @RequestMapping("/permission/getMenu")
//    public String dl(@RequestBody User user){
//        System.out.println(user.toString());
////        List<User> users=userservice.findall();
////        for(User u:users){
////            System.out.println(u.toString());
////            if(u.getUsername().equals(user.getUsername())&&u.getPassword().equals(user.getPassword())) {
////                return "a";
////            }
////        }
//        return "b";
//    }
//    @RequestMapping("/register/getmenu")
//    public String create(@RequestBody User user) {
//        List<User> users = userservice.findall();
//        System.out.println("提交");
//        int i=0;
//        for(User u:users){
//            if(u.getUsername().equals(user.getUsername())){
//                i=1;
//            }
//        }
//        if(i==0){
//            userservice.add(user);
//            return "注册成功";
//        }
//        else
//        System.out.println(user.toString());
//            return "注册失败";
//    }
//    @RequestMapping("findall")
//    public List<User> findall(){
//        return userservice.findall();
//    }
//    @RequestMapping("/user/info")
//    public User info(@RequestBody User user){
//        System.out.println(user.toString());
//        return userservice.findone(user);
//    }
//    @RequestMapping("/user/change")
//    public User change(@RequestBody User user){
//        System.out.println(user.toString());
//        userservice.update(user);
//        return user;
//    }
//    @GetMapping("/test1")
//    public String test1(){
//        System.out.println("nnnn");
//        return "aaaa";
//    }
//}
//
