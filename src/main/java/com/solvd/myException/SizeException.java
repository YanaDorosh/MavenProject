package com.solvd.myException;

public class SizeException extends Exception {

    public final static String MESSAGE = "Size is incorrect. Enter size more than 3 miters ";

    public SizeException() {

        super(MESSAGE);

    }
}
