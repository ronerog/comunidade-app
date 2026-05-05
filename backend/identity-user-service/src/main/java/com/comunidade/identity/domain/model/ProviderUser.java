package com.comunidade.identity.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("PROVIDER")
@Getter
@Setter
public class ProviderUser extends BaseUser {

    @Column(length = 255)
    private String companyName;

    @Column(columnDefinition = "TEXT")
    private String biography;
}
