package com.solvd.models;

public class Ships {
    private Long id;
    private String name;
    private Integer speed;
    private Double size;

    public Ships() {
    }

    public Ships(Long id, String name, Integer speed, Double size) {
        this.id = id;
        this.name = name;
        this.speed = speed;
        this.size = size;
    }

    public Long  getId() {
        return id;
    }

    public void setId(Long  id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }
}
