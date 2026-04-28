package com.comunidade.catalog.domain.repository;

import com.comunidade.catalog.domain.model.ServiceItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

// TODO: Interface de repositório para ServiceItem
@Repository
public interface ServiceRepository extends JpaRepository<ServiceItem, UUID> {
}
