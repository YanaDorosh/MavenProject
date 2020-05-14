package com.solvd.ships;

import com.solvd.constatnts.IConstants;

public abstract class Boat implements IConstants {

    private double buoyancy;
    private int size;
    private int speed;
    public static int count = 1;


    public Boat() {
    }

    public Boat(double buoyancy, int size, int speed)  {

        this.buoyancy = buoyancy;
        this.speed = speed;
        this.size = size;
    }


    public double getBuoyancy() {
        return buoyancy;
    }

    public int getSize() {
        return size;
    }

    public int getSpeed() {
        return KNOT/speed  ;
    }

    public final String getInfoBoat() {

        String buoyancyStr = String.valueOf(getBuoyancy());
        String sizeStr = String.valueOf(getSize());
        String speedStr = String.valueOf(getSpeed());
        String infoBoat = " Buoyancy: " + getBuoyancy() + "   " + "Size: " + sizeStr + "  Speed: " + speedStr;
        return infoBoat;
    }
    public static void countNumeration() {
        if (count != 1) {
            count = 1;
        }
    }
}
