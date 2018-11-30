package com.sample.repository;

import com.sample.model.Sensor;
import com.sample.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SensorRepository extends JpaRepository<Sensor, Long> {

    List<Sensor> findSensorsByUserId(User user);

}
