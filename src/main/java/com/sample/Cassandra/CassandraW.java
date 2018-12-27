package com.sample.Cassandra;

import java.util.HashMap;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.Row;
import com.sample.serv.serviceS;
import com.sample.serv.serviceT;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Service;


@Service("cassandra")
    public class CassandraW {
        static String serverIP = "192.168.99.100";
        static int port = 9042;
        static String keyspace = "sample";
        static String query;
        static HashMap<String,String> data;



        public void create(String user){
            Cluster cluster = Cluster.builder().addContactPoints(serverIP).withPort(port).build();
            Session session = cluster.connect(keyspace);
            query= "CREATE TABLE IF NOT EXISTS "+user+" (data text, value text, PRIMARY KEY (data));";
            session.execute(query);
            session.close();
            cluster.close();
        }

        public HashMap <String,String> getAllData(String user){
            data = new HashMap<>();
            Cluster cluster = Cluster.builder().addContactPoints(serverIP).withPort(port).build();
            Session session = cluster.connect(keyspace);
            query= "SELECT * FROM "+user+" ;";
            for (Row rows : session.execute(query)) {
                data.put(rows.getString(0),rows.getString(1));
            }
            session.close();
            cluster.close();
            return data;
        }

        public String getLastData(String user){

            String lastdata = null;
        Cluster cluster = Cluster.builder().addContactPoints(serverIP).withPort(port).build();
        Session session = cluster.connect(keyspace);
        query = "SELECT value FROM "+user+";";
        for (Row rows : session.execute(query)) {
         lastdata = rows.getString(0);
        }
        session.close();
        cluster.close();
        return lastdata;
    }

    public void createSchedulerBool (String sensorName) throws SchedulerException, InterruptedException{
        try {

            serviceS n = new serviceS();
            n.set(sensorName);
            JobDetail job = JobBuilder.newJob(serviceS.class)
                    .withIdentity("job2", "group2")
                    .storeDurably()
                    .build();

            Trigger trigger1 = TriggerBuilder
                    .newTrigger()
                    .withIdentity("trigger2", "group2")
                    .withSchedule(CronScheduleBuilder
                            .cronSchedule("0/5 * * * * ?"))
                    .forJob(job)
                    .build();

            SchedulerFactory schedFact = new StdSchedulerFactory();
            Scheduler sched = schedFact.getScheduler();
            sched.start();
            sched.addJob(job, true);
            sched.scheduleJob(trigger1);
        }catch (SchedulerException ex){
            ex.printStackTrace();
        }
    }

    public void createSchedulerInt (String sensorName) throws SchedulerException, InterruptedException{
            try {

                serviceT n = new serviceT();
                n.set(sensorName);
                JobDetail job = JobBuilder.newJob(serviceT.class)
                        .withIdentity("job1", "group1")
                        .storeDurably()
                        .build();

                Trigger trigger1 = TriggerBuilder
                        .newTrigger()
                        .withIdentity("trigger1", "group1")
                        .withSchedule(CronScheduleBuilder
                                .cronSchedule("0/5 * * * * ?"))
                        .forJob(job)
                        .build();

                SchedulerFactory schedFact = new StdSchedulerFactory();
                Scheduler sched = schedFact.getScheduler();
                sched.start();
                sched.addJob(job, true);
                sched.scheduleJob(trigger1);
            }catch (SchedulerException ex){
                ex.printStackTrace();
            }
        }


    }


