package com.sample.service;

import com.sample.generic.GenericServiceImpl;
import com.sample.model.Template;
import com.sample.repository.TemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("templateService")
@Transactional
public class TemplateServiceImpl extends GenericServiceImpl<Template> implements TemplateService {

    @Autowired
    private TemplateRepository templateRepository;

    @Override
    protected JpaRepository<Template, Long> getRepository() {
        return templateRepository;
    }

}
