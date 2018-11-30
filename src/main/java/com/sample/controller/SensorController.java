package com.sample.controller;

import com.sample.controller.json.NewSensor;
import com.sample.model.Sensor;
import com.sample.service.SensorService;
import com.sample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/sensor")
public class SensorController {

    private SensorService sensorService;

    private UserService userService;

    @RequestMapping(value = "/sensors", method = RequestMethod.GET)
    public List<Sensor> sensors(){
//        List<Sensor> sensors = new ArrayList<>();
//        sensors.add(new Sensor("Температура воздуха", "text", "25\u00b0С", "Гостиная"));
//        sensors.add(new Sensor("Влажность", "text","42%", "Гостиная"));
//        sensors.add(new Sensor("Датчик протекания", "warning", "Показатель превышен!", "Ванная комната"));
//        sensors.add(new Sensor("Датчик протекания", "text","-", "Кухня"));
//        sensors.add(new Sensor("Температура воздуха", "text","23\u00b0С", "Комната Машеньки"));
//        sensors.add(new Sensor("Ночной светильник", "bool", "true", "Комната Славика"));
//        sensors.add(new Sensor("Датчик газа", "text","-", "Кухня"));
//        sensors.add(new Sensor("Сигнализация", "bool","false", "Общая"));
        return sensorService.findByUserId(userService.findUserById(1L));
    }

    @RequestMapping(value = "/newSensor", method = RequestMethod.POST)
    public void newSensor(@RequestBody NewSensor newSensor){
        System.out.println(newSensor);
    }

    @Autowired
    public SensorController(SensorService sensorService, UserService userService){
        this.sensorService = sensorService;
        this.userService = userService;
    }
}