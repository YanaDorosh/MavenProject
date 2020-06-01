package com.solvd.dao;

import com.solvd.models.Ships;
import sun.awt.image.ShortInterleavedRaster;

import java.util.List;

public interface IShips {

    Ships getShipsId(Integer id);

    List<Ships> getShips();

    void insertShips(Ships entity);

    void deleteShips(Ships entity);

    void updateShips(Ships entity);

}

