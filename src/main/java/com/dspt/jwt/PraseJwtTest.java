package com.dspt.jwt;//package com.dspt.jwt;
//
//import com.dspt.entity.User;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
////token的解析
////有状态登录  服务器端保存用户信息
////无状态登录  服务器端没有保存用户信息   无状态效率比有状态效率高
//public class PraseJwtTest {
//    public static final String SECRET="sdfdssdfsferse4wf4tswefw212323322sdfwq423fsdf23rfew4rwfewer4tegret";
//    public static User tokenToOut(String token) {
//        Claims claims = Jwts.parser()
//                .setSigningKey(SECRET)
//                .parseClaimsJws(token)
//                .getBody();
//        User user=new User();
//        user.setUsername(claims.get("username").toString());
//        user.setRoot(claims.get("root").toString());
//        return user;
//    }
//}
