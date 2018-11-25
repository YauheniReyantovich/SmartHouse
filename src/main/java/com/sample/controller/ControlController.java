package com.sample.controller;


import com.sample.controller.json.ControlChanger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/controller")
public class ControlController {

    @RequestMapping(value = "/changeState", method = RequestMethod.POST)
    public void newSensor(@RequestBody ControlChanger state){
        System.out.println(state);
    }

}
