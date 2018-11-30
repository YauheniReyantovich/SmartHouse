package com.sample.service;

import com.sample.generic.GenericServiceImpl;
import com.sample.model.Sensor;
import com.sample.model.User;
import com.sample.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("sensorService")
@Transactional(readOnly=false)
public class SensorServiceImpl extends GenericServiceImpl<Sensor> implements SensorService {

    private SensorRepository sensorRepository;

    @Override
    protected JpaRepository<Sensor, Long> getRepository() {
        return sensorRepository;
    }

    @Override
    public List<Sensor> findByUserId(User user) {
        return sensorRepository.findSensorsByUserId(user);
    }

    @Override
    public void deleteBySensorId(long sensorId) {
        getRepository().delete(sensorId);
    }

    @Autowired
    public  SensorServiceImpl(SensorRepository sensorRepository){
        this.sensorRepository = sensorRepository;
    }
}
