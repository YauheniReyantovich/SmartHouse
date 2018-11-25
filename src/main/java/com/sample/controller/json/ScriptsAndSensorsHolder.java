package com.sample.controller.json;

import java.util.List;

public class ScriptsAndSensorsHolder {

    private List<Sensor> sensors;
    private List<Script> scripts;

    public ScriptsAndSensorsHolder(){}

    public ScriptsAndSensorsHolder(List<Sensor> sensors, List<Script> scripts) {
        this.sensors = sensors;
        this.scripts = scripts;
    }

    public List<Sensor> getSensors() {
        return sensors;
    }

    public void setSensors(List<Sensor> sensors) {
        this.sensors = sensors;
    }

    public List<Script> getScripts() {
        return scripts;
    }

    public void setScripts(List<Script> scripts) {
        this.scripts = scripts;
    }

    @Override
    public String toString() {
        return "ScriptsAndSensorsHolder{" +
                "sensors=" + sensors +
                ", scripts=" + scripts +
                '}';
    }
}
