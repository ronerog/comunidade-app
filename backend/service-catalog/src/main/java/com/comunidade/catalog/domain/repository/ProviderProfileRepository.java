package com.comunidade.catalog.domain.repository;

import com.comunidade.catalog.domain.model.ProviderProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

// TODO: Interface de repositório para ProviderProfile
@Repository
public interface ProviderProfileRepository extends JpaRepository<ProviderProfile, UUID> {
}
