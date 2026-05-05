package com.comunidade.identity.api.dto;

import com.comunidade.identity.domain.model.BaseUser;
import com.comunidade.identity.domain.model.ClientUser;
import com.comunidade.identity.domain.model.UserStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record UserResponse(
        UUID id,
        String email,
        String name,
        String document,
        UserStatus status,
        LocalDateTime createdAt
) {
    public static UserResponse from(BaseUser user) {
        String name = user instanceof ClientUser c
                ? c.getFirstName() + " " + c.getLastName()
                : user.getEmail();
        return new UserResponse(
                user.getId(),
                user.getEmail(),
                name,
                user.getDocument(),
                user.getStatus(),
                user.getCreatedAt()
        );
    }
}
