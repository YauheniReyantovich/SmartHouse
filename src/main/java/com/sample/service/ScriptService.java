package com.sample.service;

import com.sample.generic.GenericService;
import com.sample.model.Script;
import com.sample.model.Sensor;
import com.sample.model.User;

import java.util.List;

public interface ScriptService extends GenericService<Script> {

//    List<Object[]> getAllScripts();

    List<Script> findScriptsByUserId(User user);
}
