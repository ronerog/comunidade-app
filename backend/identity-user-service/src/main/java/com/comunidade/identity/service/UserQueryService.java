package com.comunidade.identity.service;

import com.comunidade.identity.api.dto.UserResponse;
import com.comunidade.identity.domain.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserQueryService {

    private final UserRepository userRepository;

    public UserQueryService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse findById(UUID id) {
        return userRepository.findById(id)
                .map(UserResponse::from)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado: " + id));
    }

    // Usa o claim `email` do JWT para localizar o usuário no banco.
    // O `sub` do Keycloak só vai coincidir com nosso ID quando integrarmos o Keycloak Admin (Fase 2 avançado).
    public UserResponse findCurrent(Jwt jwt) {
        String email = jwt.getClaimAsString("email");
        return userRepository.findByEmail(email)
                .map(UserResponse::from)
                .orElseThrow(() -> new EntityNotFoundException("Usuário autenticado não encontrado na base: " + email));
    }
}
