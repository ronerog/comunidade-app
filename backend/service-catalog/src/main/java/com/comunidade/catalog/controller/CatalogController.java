package com.comunidade.catalog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// TODO: Criar endpoints para a vitrine de serviços
// Sugestões:
// - GET /api/services (Listagem geral)
// - GET /api/services/category/{id} (Filtrar)
// - POST /api/services (Criação - requer prestador logado)
@RestController
@RequestMapping("/api/services")
public class CatalogController {

    // TODO: Injetar CatalogService
}
