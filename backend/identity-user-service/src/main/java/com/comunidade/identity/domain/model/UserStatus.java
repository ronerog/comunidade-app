package com.comunidade.identity.domain.model;

/**
 * Status de um usuário na plataforma.
 * - PENDING: cadastrado, aguardando confirmação por e-mail.
 * - ACTIVE: pronto para usar a plataforma.
 * - SUSPENDED: bloqueado temporariamente (admin).
 * - DISABLED: desativado pelo próprio usuário.
 */
public enum UserStatus {
    PENDING,
    ACTIVE,
    SUSPENDED,
    DISABLED
}
