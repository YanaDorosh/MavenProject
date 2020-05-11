package com.solvd.myException;

public class SpeedException extends Exception {

    public final static String MESSAGE = "Speed is incorrect. Enter speed between 30 and 300 km";

    public SpeedException() {

        super(MESSAGE);

    }
}
