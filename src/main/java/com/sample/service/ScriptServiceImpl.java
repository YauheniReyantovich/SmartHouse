package com.sample.service;

import com.sample.generic.GenericServiceImpl;
import com.sample.model.Script;
import com.sample.model.User;
import com.sample.repository.ScriptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("scriptService")
@Transactional(readOnly=false)
public class ScriptServiceImpl extends GenericServiceImpl<Script> implements ScriptService  {

    private ScriptRepository scriptRepository;

    @Override
    protected JpaRepository<Script, Long> getRepository() {
        return scriptRepository;
    }

    public List<Script> findScriptsByUserId(User user){
        return scriptRepository.findScriptsByUserId(user);
    }

    @Override
    public void newScript(Script script) {
        create(script);
    }

    @Autowired
    public  ScriptServiceImpl(ScriptRepository scriptRepository){
        this.scriptRepository = scriptRepository;
    }
}
