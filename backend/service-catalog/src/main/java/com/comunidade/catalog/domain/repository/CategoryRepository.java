package com.comunidade.catalog.domain.repository;

import com.comunidade.catalog.domain.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// TODO: Interface de repositório para Category
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
