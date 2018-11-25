package com.sample.controller;

import com.sample.controller.json.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/script")
public class ScriptController {

    @RequestMapping(value = "/scripts", method = RequestMethod.GET)
    public ScriptsAndSensorsHolder scripts(){
        List<Script> scripts = new ArrayList<>();
        scripts.add(new Script("Температура воздуха", "< 18\u00b0С", "Обогреватель", "вкл", true));
        scripts.add(new Script("Температура воздуха", "> 27\u00b0С", "Обогреватель", "выкл", true));
        scripts.add(new Script("Датчик протекания", "работает", "", "оповещение", false));
        scripts.add(new Script("Датчик газа", "работает", "", "оповещение", true));

        List<Sensor> sensors = new ArrayList<>();
        sensors.add(new Sensor("Температура воздуха", "text"));
        sensors.add(new Sensor("Влажность", "text"));
        sensors.add(new Sensor("Датчик протекания", "warning"));
        sensors.add(new Sensor("Датчик протекания", "text"));
        sensors.add(new Sensor("Температура воздуха", "text"));
        sensors.add(new Sensor("Ночной светильник", "bool"));
        sensors.add(new Sensor("Датчик газа", "text"));
        sensors.add(new Sensor("Сигнализация", "bool"));
        return new ScriptsAndSensorsHolder(sensors, scripts);
    }

    @RequestMapping(value = "/newScript", method = RequestMethod.POST)
    public void newScript(@RequestBody NewScript newScript){
        System.out.println(newScript);
    }
}
