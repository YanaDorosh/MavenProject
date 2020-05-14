package com.solvd.ships.shipsTypes.military;

import com.solvd.ships.Boat;
import com.solvd.ships.sіwimmingPlace.INaval;
import com.solvd.ships.typeOfMovement.IEngines;

public class Military extends Boat implements INaval, IEngines, IRangeOfBattle {

    private String armament;
    private int army;
    private double range = 23.6;
    private int hulls = 7;
    private String engine = "    Is used nuclear or motor ";


    public Military() {

    }

    public Military(double buoyancy, int size, int speed, int army, String armament)  {
        super(buoyancy, size, speed);
        this.armament = armament;
        this.army = army;
    }

    public void setArmament(String value) {
        this.armament = value;
    }
    public String getArmament() {
        return this.armament;
    }
    public void setArmy(int army) {
        this.army = army;
    }
    public int getArmy() {
        return army;
    }


    public int hulls() {
        return this.hulls;

    }


    public String getInfoNaval() {
        return isNaval;
    }


    public double BattlesRange() {
        this.range = isMiters * getSize();
        return range;
    }

    public String getInfoMilitary() {

        String armament = "    Armament: " + getArmament();
        String army = "   Army "  + getArmy();

        return Boat.count++ + "  Type Warship." + getInfoBoat()+ army  + armament + getInfoEngine()+
                "   Range of Battle  " + BattlesRange()  + getInfoNaval() + "   Hulls  " + hulls() ;
    }

    @Override
    public String toString() {
        return getInfoMilitary();
    }


    public String getInfoEngine() {
        return engine;
    }
}
