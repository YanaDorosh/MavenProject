package com.solvd.shipsConstructionCompany;

import com.solvd.ships.shipsTypes.civil.transport.DryCargo;

public class Company {
    private String companyName;
    private DryCargo dryCargo;

    public Company() {
    }

    public Company(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public DryCargo getDryCargo() {
        return dryCargo;
    }

    public void setDryCargo(DryCargo dryCargo) {
        this.dryCargo = dryCargo;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyName='" + companyName + '\'' +
                ", dryCargo=" + dryCargo +
                '}';
    }
}
