package com.sample.service;

import com.sample.generic.GenericServiceImpl;
import com.sample.model.TemplateItem;
import com.sample.repository.TemplateItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service("templateItemService")
@Transactional(readOnly=false)
public class TemplateItemServiceImpl extends GenericServiceImpl<TemplateItem> implements TemplateItemService {

    @Autowired
    private TemplateItemRepository templateItemRepository;

    @Override
    protected JpaRepository<TemplateItem, Long> getRepository() {
        return templateItemRepository;
    }

    @Override
    public List<TemplateItem> findByTemplateId(Long templateId) {
        return templateItemRepository.findByTemplateIdOrderByOrder(templateId);
    }

    @Override
    public void deleteByTemplateId(long templateId) {
        getRepository().delete(templateId);
    }
}
