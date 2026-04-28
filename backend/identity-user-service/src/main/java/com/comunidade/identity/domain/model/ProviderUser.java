package com.comunidade.identity.domain.model;

// TODO Fase 1: especialização de BaseUser para Prestadores (RF02).
// Anotações sugeridas:
//   @Entity
//   @DiscriminatorValue("PROVIDER")
//
// Campos específicos:
//   - companyName (String) — para razão social quando CNPJ
//   - biography   (String, @Column(columnDefinition = "TEXT")) — resumo de habilidades
//
// Observação importante de design: o MER coloca `biography` em PROVIDER_PROFILES (catalog).
// Decida onde mora: se a biografia descreve o "perfil de quem oferece serviços", faz mais
// sentido em catalog. Se descreve o usuário, fica aqui. Esta decisão de bounded context é
// parte do aprendizado — discuta antes de implementar.
public class ProviderUser extends BaseUser {

    // TODO: implementar
}
