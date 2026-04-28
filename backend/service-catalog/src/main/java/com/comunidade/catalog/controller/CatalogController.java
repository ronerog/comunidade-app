package com.comunidade.catalog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// TODO Fase 1: endpoints da vitrine de serviços.
//
// Endpoints:
//   GET    /api/v1/services?page=0&size=20            -> vitrine paginada
//   GET    /api/v1/services/{id}                      -> detalhe
//   GET    /api/v1/services/category/{categoryId}     -> filtro por categoria
//   POST   /api/v1/services                           -> criar (PROVIDER)
//   PUT    /api/v1/services/{id}                      -> atualizar (dono)
//   DELETE /api/v1/services/{id}                      -> remover (dono)
//
// Boas práticas:
//   - Use @AuthenticationPrincipal Jwt jwt para extrair providerId do JWT
//     (UUID.fromString(jwt.getSubject())).
//   - Use Pageable do Spring Data — já interpreta page/size/sort dos query params.
//   - Retorne 201 Created com Location header no POST.
@RestController
@RequestMapping("/api/v1/services")
public class CatalogController {

    // TODO: injetar CatalogService e implementar endpoints
}
