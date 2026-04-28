package com.comunidade.catalog.service;

import org.springframework.stereotype.Service;

// TODO Fase 1: lógica de negócio do catálogo (vitrine + CRUD do prestador).
//
// Métodos sugeridos:
//   - Page<ServiceResponse> listActiveServices(Pageable pageable);
//   - Page<ServiceResponse> listByCategory(Long categoryId, Pageable pageable);
//   - ServiceResponse findById(UUID id);
//   - ServiceResponse createService(UUID providerId, CreateServiceRequest req);
//   - ServiceResponse updateService(UUID providerId, UUID serviceId, UpdateServiceRequest req);
//   - void deleteService(UUID providerId, UUID serviceId);
//
// Fase 5 — cache:
//   @Cacheable(value = "vitrine", key = "#pageable.pageNumber + '-' + #pageable.pageSize")
//   public Page<ServiceResponse> listActiveServices(Pageable pageable) { ... }
//
//   @CacheEvict(value = "vitrine", allEntries = true)
//   public ServiceResponse createService(...) { ... }
//
// Fase 3 — eventos:
//   Após createService, publicar `service.published` para o notification-service
//   (avisar usuários interessados na categoria? envio de e-mail por enquanto).
@Service
public class CatalogService {

    // TODO: injetar repositórios (ServiceRepository, CategoryRepository, ProviderProfileRepository)
    //       e ServiceEventPublisher (Fase 3)
}
