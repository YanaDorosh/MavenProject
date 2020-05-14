package com.solvd.ships.shipsTypes.civil.transport;

public class DryCargo {

    private String name;
    private String operator;
    private int year;
    private int imo_number;

    public DryCargo() {

    }

    public DryCargo(String name, String operator, int year, int imo_number) {
        this.name = name;
        this.operator = operator;
        this.year = year;
        this.imo_number = imo_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getImo_number() {
        return imo_number;
    }

    public void setImo_number(int imo_number) {
        this.imo_number = imo_number;
    }

    @Override
    public String toString() {
        return "DryCargo{" +
                "name='" + name + '\'' +
                ", operator='" + operator + '\'' +
                ", year=" + year +
                ", imo_number=" + imo_number +
                '}';
    }
}
