package com.sample.service;

import com.sample.generic.GenericService;
import com.sample.model.TemplateItem;

import java.util.List;

public interface TemplateItemService extends GenericService<TemplateItem> {

    List<TemplateItem> findByTemplateId(Long templateId);

    void deleteByTemplateId(long templateId);
}
