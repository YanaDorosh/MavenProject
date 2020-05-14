package com.solvd.ships.shipsTypes.civil.service;

import com.solvd.ships.shipsTypes.civil.Civil;
import com.solvd.ships.typeOfMovement.IEngines;

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
