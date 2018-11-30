package com.sample.repository;

import com.sample.model.Script;
import com.sample.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ScriptRepository extends JpaRepository<Script, Long> {

//    @Query("select sen.id, sen.name, scr, con.id, con.name from Script as scr " +
//                                                    "left outer join scr.sensorId as sen " +
//                                                    "left outer join scr.controlID as con")
//    List<Object[]> getAllScripts();

    List<Script> findScriptsByUserId(User user);

}
