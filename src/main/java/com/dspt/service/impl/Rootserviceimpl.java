package com.dspt.service.impl;

import com.dspt.entity.User;
import com.dspt.mapper.Rootmapper;
import com.dspt.service.Rootservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class Rootserviceimpl implements Rootservice {
    @Autowired
    Rootmapper rootmapper;
    @Override
    public List<User> findall() {
        return rootmapper.findall();
    }

    @Override
    public List<User> findsome(int a, int b) {
       return rootmapper.findsome(a,b);
    }

    @Override
    public List<User> findlittle(String s) {
        return rootmapper.findlittle(s);
    }

    @Override
    public void del(String username) {
        rootmapper.del(username);
    }

    @Override
    public void add(User user) {
        rootmapper.add(user);
    }
}
