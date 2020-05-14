package com.solvd.ships.myException;

public class BouyancyException extends Exception {

    public final static String MESSAGE = "Buoyancy is incorrect. Enter number more then 0.23 and less than 0.98";

    public BouyancyException() {

        super(MESSAGE);

    }
}
