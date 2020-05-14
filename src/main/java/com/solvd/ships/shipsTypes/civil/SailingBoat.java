package com.solvd.ships.shipsTypes.civil;

import com.solvd.ships.Boat;
import com.solvd.ships.sіwimmingPlace.INaval;
import com.solvd.ships.typeOfMovement.IAutomotive;

public class SailingBoat extends Boat implements INaval, IAutomotive {

    private int sailings;
    private int hulls = 1;
    private String type;

    public SailingBoat() {

    }

    public SailingBoat(double buoyancy, int size, int speed, String type, int sailings) {
        super(buoyancy, size, speed);
        this.sailings = sailings;
        this.type=type;
    }

    public String getType(){
        return type;
    }

    public int sailings() {
        return this.sailings;
    }

    public String getInfoAutomotive() {
        String infoSailing = "    Number of sails: " + sailings();
        return Boat.count++ + " Type Sail boat. " + getType() + getInfoBoat() + infoSailing + combinePower()
                + "   Hulls:  " + hulls() + " " + getInfoNaval();
    }


    public void humanPowered(String isType) {
    }

    public String motorboat() {
        return String.valueOf(" engine ");
    }

    public String combinePower() {
        return "   Used two types of power:" + motorboat() + "and " + isPower;
    }


    public int hulls() {
        return this.hulls;
    }


    public String getInfoNaval() {
        return isNaval;
    }

    @Override
    public String toString() {
        return getInfoAutomotive();
    }
}
