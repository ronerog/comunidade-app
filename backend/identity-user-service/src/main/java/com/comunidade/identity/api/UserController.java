package com.comunidade.identity.api;

import com.comunidade.identity.api.dto.RegisterClientRequest;
import com.comunidade.identity.api.dto.RegisterProviderRequest;
import com.comunidade.identity.api.dto.UserResponse;
import com.comunidade.identity.service.UserQueryService;
import com.comunidade.identity.service.UserRegistrationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserRegistrationService registrationService;
    private final UserQueryService queryService;

    public UserController(UserRegistrationService registrationService, UserQueryService queryService) {
        this.registrationService = registrationService;
        this.queryService = queryService;
    }

    @PostMapping("/clients")
    public ResponseEntity<UserResponse> registerClient(@Valid @RequestBody RegisterClientRequest req,
                                                       UriComponentsBuilder uriBuilder) {
        UserResponse response = registrationService.registerClient(req);
        var location = uriBuilder.path("/api/v1/users/{id}").buildAndExpand(response.id()).toUri();
        return ResponseEntity.created(location).body(response);
    }

    @PostMapping("/providers")
    public ResponseEntity<UserResponse> registerProvider(@Valid @RequestBody RegisterProviderRequest req,
                                                         UriComponentsBuilder uriBuilder) {
        UserResponse response = registrationService.registerProvider(req);
        var location = uriBuilder.path("/api/v1/users/{id}").buildAndExpand(response.id()).toUri();
        return ResponseEntity.created(location).body(response);
    }

    @GetMapping("/me")
    public ResponseEntity<UserResponse> me(@AuthenticationPrincipal Jwt jwt) {
        return ResponseEntity.ok(queryService.findCurrent(jwt));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(queryService.findById(id));
    }
}
