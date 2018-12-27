package com.sample.service;

import com.sample.Cassandra.CassandraW;
import com.sample.generic.GenericServiceImpl;
import com.sample.model.Sensor;
import com.sample.model.User;
import com.sample.repository.SensorRepository;
import com.sample.serv.serviceS;
import com.sample.serv.serviceT;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("sensorService")
@Transactional(readOnly=false)
public class SensorServiceImpl extends GenericServiceImpl<Sensor> implements SensorService {

    private SensorRepository sensorRepository;

    private CassandraW cassandraW;

    @Override
    protected JpaRepository<Sensor, Long> getRepository() {
        return sensorRepository;
    }


    @Override
    public List<Sensor> findByUserId(User user) {
        List<Sensor> sensors = sensorRepository.findSensorsByUserId(user);
        for(Sensor sensor: sensors){
            if(!sensor.getStateType().equals("warning")) {
                sensor.setState(cassandraW.getLastData("sensor_" + sensor.getId()));
            }

        }
        for(Sensor sensor: sensors){
            System.out.println(sensor);

        }
        return sensors;

    }

    @Override
    public void newSensor(Sensor sensor) {
        if(sensor.getStateType().equals("warning")){
            sensor.setState("Показатель превышен!");
            System.out.println(sensor);
            create(sensor);
        }
        else{
            sensor.setState("sensor_"+sensor.getId());
            System.out.println(sensor);
            create(sensor);
            cassandraW.create("sensor_"+sensor.getId());
            try {
                if(sensor.getStateType().equals("bool")) {
                    cassandraW.createSchedulerBool("sensor_" + sensor.getId());
                }
                else{
                    cassandraW.createSchedulerInt("sensor_" + sensor.getId());

                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            } catch (SchedulerException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void deleteBySensorId(long sensorId) {
        getRepository().delete(sensorId);
    }

    @Autowired
    public  SensorServiceImpl(SensorRepository sensorRepository, CassandraW cassandraW){
        this.sensorRepository = sensorRepository;
        this.cassandraW = cassandraW;
    }
}
