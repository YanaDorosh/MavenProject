package com.solvd.ships.civil.service.servicetype;

import com.solvd.menu.CivilMenu;
import com.solvd.ships.civil.service.Service;
import org.apache.log4j.Logger;

public class Fishing extends Service {

    private int ton;
    private final double KILOMITR = 1.852;

    public Fishing() {

    }

    public Fishing(double buoyancy, int size, int speed, String classification, int ton)  {
        super(buoyancy, size, speed, classification);
        this.ton = ton;
    }

    public double distance() {
       double kilometer = (this.ton / this.KILOMITR) * 100;
        return kilometer;
    }

    public double distance(double ton) {
        double kilometer =(this.ton / this.KILOMITR) * 100;
        return kilometer;
    }

    public String getInfoFishing() {
        String distanceStr = "  Kilomiters:  " + String.valueOf(distance());
        return  "Fishing. " + getInfoService() + distanceStr;
    }

    @Override
    public String toString() {
        return getInfoFishing();
    }
}
