package com.sample.controller;

import com.sample.generic.GenericWebService;
import com.sample.model.TemplateItem;
import com.sample.service.TemplateItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/template-items")
public class TemplateItemWebService extends GenericWebService<TemplateItem> {

    private final TemplateItemService service;

    @Autowired
    public TemplateItemWebService(TemplateItemService service) {
        super(service);
        this.service = service;
    }
}
