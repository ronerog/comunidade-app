package com.comunidade.identity.integration.viacep;

import org.springframework.stereotype.Component;

// TODO Fase 6: cliente HTTP para a API pública do ViaCEP.
//
// Padrão: este é um Adapter. O resto do código (Service) NÃO conhece a estrutura JSON
// do ViaCEP — só recebe um ViaCepAddress (DTO interno). Isso permite trocar de provedor
// no futuro (BrasilAPI, AwesomeAPI) sem mudar o domínio.
//
// Tecnologia recomendada: RestClient (Spring 6.1+) — mais ergonômico que RestTemplate
// e síncrono (mais simples que WebClient para esse caso).
//
// Esqueleto:
//
//   @Component
//   public class ViaCepClient {
//
//       private final RestClient restClient;
//
//       public ViaCepClient(RestClient.Builder builder,
//                           @Value("${integrations.viacep.base-url}") String baseUrl) {
//           this.restClient = builder.baseUrl(baseUrl).build();
//       }
//
//       @Cacheable(value = "viacep", key = "#cep")              // Fase 5: cache no Redis
//       @CircuitBreaker(name = "viacep", fallbackMethod = "fallback")  // Fase 6: Resilience4j
//       @Retry(name = "viacep")                                 // Fase 6
//       public ViaCepAddress findByCep(String cep) {
//           return restClient.get()
//               .uri("/{cep}/json/", cep)
//               .retrieve()
//               .body(ViaCepAddress.class);
//       }
//
//       // TODO: fallback que devolve um endereço vazio ou lança exceção tratada
//   }
@Component
public class ViaCepClient {

    // TODO Fase 6: implementar
}
