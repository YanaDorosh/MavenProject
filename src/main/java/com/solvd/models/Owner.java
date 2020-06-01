package com.solvd.models;

public class Owner {
    private Integer id;
    private String name;
    private Integer year;
    private String country;

    public Owner() {
    }

    public Owner(Integer id, String name, Integer year, String country) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.country = country;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", country='" + country + '\'' +
                '}';
    }
}
