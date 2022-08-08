//package com.dspt.jwt;
//
//import com.dspt.entity.User;
//import io.jsonwebtoken.JwtBuilder;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//
//import java.util.Date;
//public class Creattoken {
//    public static final long TIME =1000*60*60*24;
//    public static final String SECRET="sdfdssdfsferse4wf4tswefw212323322sdfwq423fsdf23rfew4rwfewer4tegret";
//    public static String gettoken(User user){
//        //Jwts.builder()生成
//        //Jwts.parser()验证
//        JwtBuilder jwtBuilder= Jwts.builder()
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis()+TIME))
//                .claim("username",user.getUsername())
//                .claim("root",user.getRoot())
//                        .signWith(SignatureAlgorithm.HS256,SECRET);
//        //设置过期时间
//        //前三个为载荷playload 最后一个为头部 header
//        System.out.println(jwtBuilder.compact());
//        return jwtBuilder.compact();
//    }
//}
