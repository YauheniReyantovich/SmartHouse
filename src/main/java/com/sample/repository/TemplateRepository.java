package com.sample.repository;

import com.sample.model.Template;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TemplateRepository extends JpaRepository<Template, Long> {

    @Override
    @Query("select new Template(t.id, t.name, t.description) from Template as t")
    List<Template> findAll();

}
