package com.comunidade.identity.domain.model;

/**
 * Gênero do cliente (RF01).
 * O MER define códigos numéricos: 1-Masculino, 2-Feminino, 3-Outro.
 * Use este enum nas entidades; o JPA pode persistir como STRING (recomendado) ou ORDINAL.
 */
public enum Gender {
    MALE,
    FEMALE,
    OTHER
}
