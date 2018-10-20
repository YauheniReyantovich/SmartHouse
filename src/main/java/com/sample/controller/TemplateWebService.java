package com.sample.controller;

import com.sample.generic.GenericWebService;
import com.sample.model.Template;
import com.sample.model.TemplateItem;
import com.sample.service.TemplateItemService;
import com.sample.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/templates")
public class TemplateWebService extends GenericWebService<Template> {

    @Autowired
    private TemplateItemService itemService;

    @Autowired
    private TemplateService templateService;

    @Autowired
    public TemplateWebService(TemplateService service) {
        super(service);
    }

    @RequestMapping(value = "/{id}/items", method = RequestMethod.GET)
    public List<TemplateItem> getTemplateItems(@PathVariable Long id) {
        return itemService.findByTemplateId(id);
    }

    @RequestMapping(value = "/{id}/items", method = RequestMethod.POST)
    @ResponseBody
    public List<TemplateItem> setTemplateItems(@PathVariable Long id, @RequestBody List<TemplateItem> templateItems) {
        return (List<TemplateItem>) itemService.saveEntities(templateItems);
    }
}
