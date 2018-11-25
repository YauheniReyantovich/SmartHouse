package com.sample.controller.json;

public class ControlChanger {
    private Integer index;
    private  Boolean value;

    ControlChanger(){}

    public ControlChanger(Integer index, Boolean value) {
        this.index = index;
        this.value = value;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Boolean getValue() {
        return value;
    }

    public void setValue(Boolean value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ControlChanger{" +
                "index=" + index +
                ", value=" + value +
                '}';
    }
}
