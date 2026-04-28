package com.comunidade.identity.domain.repository;

import com.comunidade.identity.domain.model.ClientUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

// TODO Fase 1: repositório específico para ClientUser (RF01).
// Por causa do Single Table Inheritance, esta interface naturalmente
// filtra apenas usuários do tipo CLIENT (DiscriminatorValue).
@Repository
public interface ClientUserRepository extends JpaRepository<ClientUser, UUID> {
}
