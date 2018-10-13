package com.sample.generic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Transactional(readOnly = true)
public abstract class GenericServiceImpl<T extends Serializable> implements GenericService<T> {

    @Override
    public T findById(Long id) {
        return getRepository().findOne(id);
    }

    @Override
    public List<T> list() {
        return getRepository().findAll();
    }

    @Override
    @Transactional
    public T create(T item) {
        return getRepository().save(item);
    }

    @Override
    @Transactional
    public Collection<T> saveEntities(Collection<T> entities) {
        return getRepository().save(entities);
    }

    @Override
    @Transactional
    public T update(T item) {
        return getRepository().saveAndFlush(item);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        getRepository().delete(id);
    }

    @Override
    @Transactional
    public void deleteEntities(Collection<T> entities) {
        getRepository().deleteAll();
    }

    protected abstract JpaRepository<T, Long> getRepository();
}
