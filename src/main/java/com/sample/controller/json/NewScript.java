package com.sample.controller.json;

public class NewScript {

    private String comment;
    private Integer comparedValue;
    private String condition;
    private String control;
    private String movement;
    private String sensor;

    public NewScript(){}

    public NewScript(String comment, Integer comparedValue, String condition, String control, String movement, String sensor) {
        this.comment = comment;
        this.comparedValue = comparedValue;
        this.condition = condition;
        this.control = control;
        this.movement = movement;
        this.sensor = sensor;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getComparedValue() {
        return comparedValue;
    }

    public void setComparedValue(Integer comparedValue) {
        this.comparedValue = comparedValue;
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

    public String getMovement() {
        return movement;
    }

    public void setMovement(String movement) {
        this.movement = movement;
    }

    public String getSensor() {
        return sensor;
    }

    public void setSensor(String sensor) {
        this.sensor = sensor;
    }

    @Override
    public String toString() {
        return "NewScript{" +
                "comment='" + comment + '\'' +
                ", comparedValue=" + comparedValue +
                ", condition='" + condition + '\'' +
                ", control='" + control + '\'' +
                ", movement='" + movement + '\'' +
                ", sensor='" + sensor + '\'' +
                '}';
    }
}
