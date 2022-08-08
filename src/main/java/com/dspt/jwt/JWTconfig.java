package com.dspt.jwt;

import com.alibaba.druid.util.StringUtils;
import com.dspt.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class JWTconfig {
    // token时效：24小时
    public static final long EXPIRE = 1000 * 60 * 60 * 24;
    // 签名哈希的密钥，对于不同的加密算法来说含义不同
    public static final String APP_SECRET = "ukc8BDbRigUDsdfsdfeedfsdaY6pZFfWus2jZWLPJSxusHO";
    public static String getJWTtoken(User user){
        String JWTtoken= Jwts.builder()
//                .setHeaderParam("username",user.getUsername())
//                .setHeaderParam("root",user.getRoot())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .claim("username",user.getUsername())
                .claim("root",user.getRoot())
                .claim("name",user.getName())
//                .claim("sission",request.getRequestedSessionId())
                .signWith(SignatureAlgorithm.HS256,APP_SECRET)
                .compact();
        System.out.println(user.toString());
        System.out.println(JWTtoken);
        return JWTtoken;
    }
    /**
     * 判断token是否存在与有效
     * @param jwtToken token字符串
     * @return 如果token有效返回true，否则返回false
     */
    public static boolean checkToken(String jwtToken) {
        if(StringUtils.isEmpty(jwtToken)) return false;
        try {
            Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static String gettokenUsername(String JWTtoken){
//        String JWTtoken=request.getHeader("token");

//        if(StringUtils.isEmpty(JWTtoken)){
//            System.out.println("kong");
//            return null;}
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(JWTtoken);
        Claims claims = claimsJws.getBody();
        User user=new User();
        user.setUsername((String) claims.get("username"));
        user.setRoot((String) claims.get("root"));
        System.out.println(claims.toString());
        return claims.get("username").toString();
    }
    public static String gettokenName(String JWTtoken){
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(JWTtoken);
        Claims claims = claimsJws.getBody();
        return claims.get("name").toString();
    }
    public static String gettokenRoot(String JWTtoken){
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(JWTtoken);
        Claims claims = claimsJws.getBody();
        return claims.get("root").toString();
    }
}
