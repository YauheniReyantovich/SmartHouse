package com.sample.service;

import com.sample.generic.GenericService;
import com.sample.model.Sensor;
import com.sample.model.User;

import java.util.List;

public interface SensorService extends GenericService<Sensor> {

    List<Sensor> findByUserId(User user);

    void newSensor(Sensor sensor);

    void deleteBySensorId(long sensorId);
}
