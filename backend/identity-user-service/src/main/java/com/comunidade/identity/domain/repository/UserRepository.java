package com.comunidade.identity.domain.repository;

import com.comunidade.identity.domain.model.BaseUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

// TODO Fase 1: repositório base para qualquer usuário (Client ou Provider).
// Métodos sugeridos para você implementar declarativamente (Spring Data gera a query):
//   - Optional<BaseUser> findByEmail(String email);
//   - Optional<BaseUser> findByDocument(String document);
//   - boolean existsByEmail(String email);
//   - boolean existsByDocument(String document);
@Repository
public interface UserRepository extends JpaRepository<BaseUser, UUID> {

    Optional<BaseUser> findByEmail(String email);
    Optional<BaseUser> findByDocument(String document);
    boolean existsByEmail(String email);
    boolean existsByDocument(String document);
}
