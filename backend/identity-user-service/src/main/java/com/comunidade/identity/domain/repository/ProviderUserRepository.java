package com.comunidade.identity.domain.repository;

import com.comunidade.identity.domain.model.ProviderUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

// TODO Fase 1: repositório específico para ProviderUser (RF02).
@Repository
public interface ProviderUserRepository extends JpaRepository<ProviderUser, UUID> {
}
