package com.dspt.service.impl;

import com.dspt.entity.User;
import com.dspt.mapper.Usermapper;
import com.dspt.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class Userservicecimpl implements Userservice {
    @Autowired
    Usermapper usermapper;


    @Override
    public void add(User user) {
         usermapper.add(user);
    }

//    @Override
//    public List<User> findall() {
//        return usermapper.findall();
//    }

    @Override
    public User findone(User user) {
        return usermapper.findone(user);
    }

    @Override
    public User findone(String username) {
        return usermapper.findone(username);
    }

    @Override
    public void update(User user) {
         usermapper.update(user);
    }

    @Override
    public void updatetx(String url,String username) {
        usermapper.updatetx(url,username);
        System.out.println("xiug");
    }

    public Userservicecimpl() {
    }
}
