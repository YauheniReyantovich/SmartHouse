package com.sample.Cassandra;

import java.util.HashMap;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.Row;




    public class cassandraW {
        static String serverIP = "192.168.99.100";
        static int port = 9042;
        static String keyspace = "sample";
        static String query;
        static HashMap<String,String> data;


        public static void create(String user){
            Cluster cluster = Cluster.builder().addContactPoints(serverIP).withPort(port).build();
            Session session = cluster.connect(keyspace);
            query= "CREATE TABLE IF NOT EXISTS "+user+" (data text, value text, PRIMARY KEY (data));";
            session.execute(query);
            session.close();
            cluster.close();
        }

        public static HashMap <String,String> get(String user){
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

    }


