package com.comunidade.identity.service;

import com.comunidade.identity.api.dto.AddressDto;
import com.comunidade.identity.api.dto.RegisterClientRequest;
import com.comunidade.identity.api.dto.RegisterProviderRequest;
import com.comunidade.identity.api.dto.UserResponse;
import com.comunidade.identity.domain.model.Address;
import com.comunidade.identity.domain.model.ClientUser;
import com.comunidade.identity.domain.model.ProviderUser;
import com.comunidade.identity.domain.model.UserStatus;
import com.comunidade.identity.domain.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserRegistrationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserRegistrationService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public UserResponse registerClient(RegisterClientRequest req) {
        validateUniqueness(req.email(), req.document());

        ClientUser user = new ClientUser();
        fillBaseFields(user, req.email(), req.password(), req.document(), req.mobilePhone());
        user.setFirstName(req.firstName());
        user.setLastName(req.lastName());
        user.setBirthDate(req.birthDate());
        user.setGender(req.gender());

        Address address = buildAddress(req.address(), user);
        user.setAddress(address);

        userRepository.saveAndFlush(user);
        return UserResponse.from(user);
    }

    @Transactional
    public UserResponse registerProvider(RegisterProviderRequest req) {
        validateUniqueness(req.email(), req.document());

        ProviderUser user = new ProviderUser();
        fillBaseFields(user, req.email(), req.password(), req.document(), req.mobilePhone());
        user.setCompanyName(req.companyName());
        user.setBiography(req.biography());

        Address address = buildAddress(req.address(), user);
        user.setAddress(address);

        userRepository.saveAndFlush(user);
        return UserResponse.from(user);
    }

    private void validateUniqueness(String email, String document) {
        if (userRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("E-mail já cadastrado");
        }
        if (userRepository.existsByDocument(document)) {
            throw new IllegalArgumentException("Documento já cadastrado");
        }
    }

    private void fillBaseFields(com.comunidade.identity.domain.model.BaseUser user,
                                String email, String password, String document, String mobilePhone) {
        user.setEmail(email);
        user.setPasswordHash(passwordEncoder.encode(password));
        user.setDocument(document);
        user.setMobilePhone(mobilePhone);
        user.setStatus(UserStatus.PENDING);
    }

    private Address buildAddress(AddressDto dto, com.comunidade.identity.domain.model.BaseUser user) {
        Address address = new Address();
        address.setUser(user);
        address.setCep(dto.cep());
        address.setLogradouro(dto.logradouro());
        address.setNumber(dto.number());
        address.setBairro(dto.bairro());
        address.setCity(dto.city());
        address.setState(dto.state());
        return address;
    }
}
