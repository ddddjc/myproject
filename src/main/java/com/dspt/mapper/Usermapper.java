package com.dspt.mapper;

import com.dspt.entity.User;
import org.apache.ibatis.annotations.Param;

public interface Usermapper {
    //添加
     void add(User user);
    //查询
//    List<User> findall();
    //查询单个
//    User findone(String username);
    User findone(User user);
    User findone(String username);
    //修改
    void update(User user);

    void updatetx(@Param("url") String url,@Param("username") String username);

}
