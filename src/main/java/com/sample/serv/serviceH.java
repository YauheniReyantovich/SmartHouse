package com.sample.serv;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

public class serviceH implements Job {
    static String serverIP = "192.168.99.100";
    static int port = 9042;
    static String keyspace = "sample";
    static String query;
    static public String user;
    static String value;
    static int a = 45;
    static int b = 65;

    public void execute(JobExecutionContext context) throws JobExecutionException {
        Cluster cluster = Cluster.builder().addContactPoints(serverIP).withPort(port).build();
        Session session = cluster.connect(keyspace);
        value = String.valueOf((int)(Math.random()*(b-a))+a);
        query= "INSERT INTO "+user+" (data , value) VALUES ('"+(new Date()).toString()+"','"+value+"');";
        session.execute(query);
        session.close();
        cluster.close();
    }
    public void set (String name){
        user = name;
    }
}
