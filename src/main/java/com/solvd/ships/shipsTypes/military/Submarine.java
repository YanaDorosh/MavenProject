package com.solvd.ships.shipsTypes.military;

import com.solvd.ships.typeOfMovement.Engines.INuclear;

public class Submarine extends Military implements INuclear {

    private String armament;
    private int army;
    private int range = 5;
    private int hulls = 2;

    public Submarine() {
    }

    public Submarine(double buoyancy, int size, int speed, int army, String armament)  {
        super(buoyancy, size, speed, army, armament);

    }

    public void setArmy(int value) {
        this.army = value;
    }

    public int getArmy() {
        return this.army;

    }

    @Override
    public int hulls() {
        return this.hulls;
    }

    @Override
    public double BattlesRange() {
        this.range *= isMiters * getSize();
        return range;

    }

    public String getInfoSubmarine() {
        return "Submarine " + getInfoMilitary() + getInfoNuclearEngine();

    }

    @Override
    public String toString() {
        return getInfoSubmarine();
    }

    @Override
    public String getInfoEngine() {
        return getInfoNuclearEngine();
    }

    public String getInfoNuclearEngine() {
        return " Is driven by atomic energy. ";
    }
}
