package com.sample.controller;

import com.sample.controller.json.NewScript;
import com.sample.controller.json.ScriptsAndSensorsHolder;
import com.sample.model.Script;
import com.sample.service.ScriptService;
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
@RequestMapping("/script")
public class ScriptController {

    private ScriptService scriptService;

    private SensorService sensorService;

    private UserService userService;

    @RequestMapping(value = "/scripts", method = RequestMethod.GET)
    public ScriptsAndSensorsHolder scripts(){
        return new ScriptsAndSensorsHolder(sensorService.findByUserId(userService.findUserById(1L)), scriptService.findScriptsByUserId(userService.findUserById(1L)));
    }

    @RequestMapping(value = "/newScript", method = RequestMethod.POST)
    public List<Script> newScript(@RequestBody NewScript newScript){
        Script script = new Script();
        switch (newScript.getCondition()){
            case "Значение выше": script.setCondition("more"); break;
            case "Значение ниже": script.setCondition("less"); break;
            case "Значение равно": script.setCondition("equals"); break;
            case "Значение не равно": script.setCondition("notEquals"); break;
            case "Датчик сработал": script.setCondition("работает"); break;
        }
        script.setComparedValue(script.getCondition().equals("работает") ? null : newScript.getComparedValue().toString());
        script.setAction(newScript.getMovement());
        script.setWorking(false);
        script.setSensorId(sensorService.findById(Long.valueOf(newScript.getSensor())));
        script.setControlID(script.getCondition().equals("работает") ? null : sensorService.findById(Long.valueOf(newScript.getControl())));
        script.setUserId(userService.findUserById(1L));

        scriptService.newScript(script);
        return scriptService.findScriptsByUserId(userService.findUserById(1L));
    }

    @Autowired
    public ScriptController(ScriptService scriptService, SensorService sensorService, UserService userService){
        this.scriptService = scriptService;
        this.sensorService = sensorService;
        this.userService = userService;
    }
}
