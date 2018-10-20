package com.sample.generic;

import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

public abstract class GenericWebService<T extends Serializable> {
    private final GenericService<T> service;

    protected GenericWebService(GenericService<T> service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<T> list() {
        return service.list();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public T get(@PathVariable Long id) {
        return  service.findById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public T update(@PathVariable Long id, @RequestBody T item) {
        return service.update(item);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public T create(@RequestBody T item) {
        return (T)service.create(item);
    }

}
