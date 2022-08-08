package com.dspt.service;

import com.dspt.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Rootservice {
    List<User> findall();
    List<User> findsome(@Param("a") int a, @Param("b") int b);
    List<User> findlittle(String s);
    void del(String username);
}
