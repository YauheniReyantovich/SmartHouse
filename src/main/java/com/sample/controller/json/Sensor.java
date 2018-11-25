package com.sample.controller.json;

public class Sensor {
    private String name;
    private String stateType;
    private String state;
    private String comment;

    public Sensor(String name, String stateType) {
        this.name = name;
        this.stateType = stateType;
    }

    public Sensor(String name, String stateType, String state, String comment) {
        this.name = name;
        this.stateType = stateType;
        this.state = state;
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStateType() {
        return stateType;
    }

    public void setStateType(String stateType) {
        this.stateType = stateType;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
