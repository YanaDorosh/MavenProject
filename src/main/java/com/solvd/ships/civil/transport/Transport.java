package com.solvd.ships.civil.transport;

import com.solvd.ships.civil.Civil;
import com.solvd.typeOfMovement.Engines.IMotor;

public class Transport extends Civil implements IMotor {

    private int loading;

    public Transport() {

    }

    public Transport(double buoyancy, int size, int speed, String classification)  {
        super(buoyancy, size, speed, classification);
    }

    public void setLoading(int value) {
        this.loading = value;
    }

    public int getLoading() {
        return this.loading;
    }

    public String getInfoTransport() {

        return "Type Transport. " + getInfoCivil() + getLoading();
    }

    @Override
    public String getInfoEngine() {
        return getInfoMotorEngine();
    }

    public String getInfoMotorEngine() {
        return " Is propelled by an internal combustion engine. ";
    }
}
