package com.solvd.ships.shipsTypes.civil;

import com.solvd.ships.Boat;
import com.solvd.ships.typeOfMovement.IEngines;

public class Civil extends Boat implements IEngines {

    private String classification;
    private String engine = "  Is used electricity or motor engines ";


    public Civil() {

    }

    public Civil(double buoyancy, int size, int speed, String classification) {
        super(buoyancy, size, speed);
        this.classification = classification;
    }

    public String getClassification() {
        return classification;
    }

    public String getInfoCivil() {
        return Boat.count++ + " Civil. " + getInfoBoat() + "  Classification: " + getClassification() + getInfoEngine();
    }

    @Override
    public String toString() {
        return getInfoCivil();
    }


    public String getInfoEngine() {
        return engine;
    }
}
