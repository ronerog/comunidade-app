package com.comunidade.identity.service;

import com.comunidade.identity.api.dto.UserResponse;
import com.comunidade.identity.domain.repository.UserRepository;
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
                .orElseThrow(() -> new jakarta.persistence.EntityNotFoundException("Usuário não encontrado: " + id));
    }
}
