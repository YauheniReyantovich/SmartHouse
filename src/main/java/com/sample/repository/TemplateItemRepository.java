package com.sample.repository;

import com.sample.model.TemplateItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TemplateItemRepository extends JpaRepository<TemplateItem, Long> {

    List<TemplateItem> findByTemplateIdOrderByOrder(long templateId);
}
