package com.comunidade.identity.domain.repository;

import com.comunidade.identity.domain.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

// TODO Fase 1: repositório de endereços.
// Pode ser que você nem precise dele se a relação for sempre acessada via BaseUser.address
// (cascade ALL no @OneToOne). Mantenha enquanto explora a modelagem.
@Repository
public interface AddressRepository extends JpaRepository<Address, UUID> {
}
