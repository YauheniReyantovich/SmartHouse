package com.sample.controller.json;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class Script {
    private String sensor;
    private String condition;
    private String control;
    private String action;
    private Boolean isWorking;

    Script(){}

    public Script(String sensor, String condition, String control, String action, Boolean isWorking) {
        this.sensor = sensor;
        this.condition = condition;
        this.control = control;
        this.action = action;
        this.isWorking = isWorking;
    }

    public String getSensor() {
        return sensor;
    }

    public void setSensor(String sensor) {
        this.sensor = sensor;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getControl() {
        return control;
    }

    public void setControl(String control) {
        this.control = control;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Boolean getWorking() {
        return isWorking;
    }

    public void setWorking(Boolean working) {
        isWorking = working;
    }

    @Override
    public String toString() {
        return "Script{" +
                "sensor='" + sensor + '\'' +
                ", condition='" + condition + '\'' +
                ", control='" + control + '\'' +
                ", action='" + action + '\'' +
                ", isWorking=" + isWorking +
                '}';
    }
}
