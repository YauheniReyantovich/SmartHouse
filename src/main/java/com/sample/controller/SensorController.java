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
        return sensorService.findByUserId(userService.findUserById(1L));
    }

    @RequestMapping(value = "/newSensor", method = RequestMethod.POST)
    public List<Sensor> newSensor(@RequestBody NewSensor newSensor){
        Sensor sensor = new Sensor();
        sensor.setName(newSensor.getName());
        switch (newSensor.getId() % 3){
            case 0: sensor.setStateType("text"); break;
            case 1: sensor.setStateType("warning"); break;
            case 2: sensor.setStateType("bool"); break;
        }
       // sensor.setState(sensor.getStateType().equals("bool") ? "false" : "-");
        sensor.setComment(newSensor.getComment());
        sensor.setUserId(userService.findUserById(1L));
        sensorService.newSensor(sensor);
        return sensorService.findByUserId(userService.findUserById(1L));
    }

    @Autowired
    public SensorController(SensorService sensorService, UserService userService){
        this.sensorService = sensorService;
        this.userService = userService;
    }
}