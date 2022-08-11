package com.dspt.mapper;

import com.dspt.entity.Car;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Carmapper {
    List<Car> findcar(String username);
    Car findoen(String cid);

    Car findpro(@Param("id") String id,@Param("username") String username);

    void update(Car car);
    void addcar(Car car);

    void delcar(String cid);
    void delall(String username);

}
