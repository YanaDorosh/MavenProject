package com.solvd.ships.civil.service;

import com.solvd.ships.civil.Civil;
import com.solvd.typeOfMovement.IEngines;

public class Service extends Civil implements IEngines {


    public Service() {

    }

    public Service(double buoyancy, int size, int speed, String classification)  {
        super(buoyancy, size, speed, classification);

    }

    public String getInfoService() {
        return "Type Service. " + getInfoCivil();
    }
}
