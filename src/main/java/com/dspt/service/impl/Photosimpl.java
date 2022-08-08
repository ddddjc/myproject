package com.dspt.service.impl;

import com.dspt.entity.Photos;
import com.dspt.mapper.Photosmapper;
import com.dspt.service.Photoservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class Photosimpl implements Photoservice {
    @Autowired
    Photosmapper photosmapper;
    @Override
    public List<Photos> findallphotos() {
        return photosmapper.findallphotos();
    }
}
