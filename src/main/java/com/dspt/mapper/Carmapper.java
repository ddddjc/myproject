package com.dspt.mapper;

import com.dspt.entity.Car;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Carmapper {
    List<Car> findcar(String username);
    Car findoen(String cit);
    void addcar(Car car);

    void delcar(String cid);
    void delall(String username);

}
