package com.solvd.ships.civil.service.servicetype;

import com.solvd.ships.civil.service.Service;
import com.solvd.sіwimmingPlace.INaval;

public class Icebreaker extends Service implements INaval {

    private int oil;
    private int hulls;

    public Icebreaker() {

    }

    public Icebreaker(double buoyancy, int size, int speed, String classification)  {
        super(buoyancy, size, speed, classification);
    }


    public int hulls() {
        return this.hulls;
    }


    public String getInfoNaval() {
        return isNaval;

    }

    public String getInfoIcebreaker() {
        String oilStr = "   Oil: " + oil;
        return "Icebreaker. " + getInfoService() + "    Hulls: " + hulls() + oilStr;

    }
}
