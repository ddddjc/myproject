package com.dspt.service;

import com.dspt.entity.User;

public interface Userservice {
    void add(User user);
//    List<User> findall();
    //查询单个用User
    User findone(User user);

     User findone(String username);
    //修改
    void update(User user);
    //修改头像
    void updatetx(String url,String username);
}
