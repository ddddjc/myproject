package com.dspt.mapper;

import com.dspt.entity.Buyed;

import java.util.List;

public interface Buyedmapper {
    List<Buyed> findAllBuyed(String username);

    void addbuyed(Buyed buyed);
}
