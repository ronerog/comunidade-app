# Mapeamento de Classes (Visão de Domínio Base)

O ecossistema Java (Spring Boot) refletirá a persistência através da JPA (`@MappedSuperclass` ou `@Inheritance`). O design abaixo ilustra os Aggregates de Domínio para a plataforma.

## Diagrama UML das Principais Classes do Domínio

```mermaid
classDiagram
    %% Agregado de Identidade
    class BaseUser {
        <<abstract>>
        -UUID id
        -String email
        -String password
        -String document
        -String mobilePhone
        -String profilePictureUrl
        -String documentAnexUrl
        -UserStatus status
        -Address address
    }

    class ClientUser {
        -String firstName
        -String lastName
        -LocalDate birthDate
        -Gender gender
    }

    class ProviderUser {
        -String companyName
        -ProviderProfile profile
    }

    class Address {
        -String zipCode
        -String logradouro
        -String number
        -String bairro
        -String city
        -String state
    }
    
    BaseUser <|-- ClientUser : Extends
    BaseUser <|-- ProviderUser : Extends
    BaseUser "1" *-- "1" Address : has

    %% Agregado de Catálogo de Serviços
    class ProviderProfile {
        -String biography
        -List~Category~ categories
        -List~ServiceItem~ services
    }

    class Category {
        -Long id
        -String name
    }

    class ServiceItem {
        -UUID id
        -String title
        -String description
        -String availability
        -ServiceStatus status
        -List~ServicePhoto~ photos
    }

    class ServicePhoto {
        -UUID id
        -String photoUrl
    }

    ProviderUser "1" *-- "1" ProviderProfile : has
    ProviderProfile "1" --> "*" Category : acts in
    ProviderProfile "1" --> "*" ServiceItem : publishes
    ServiceItem "1" *-- "*" ServicePhoto : contains

    %% Agregado de Notificação
    class UserRegisteredEvent {
        <<event>>
        -Long userId
        -String email
        -String name
        -LocalDateTime createdAt
    }
```

## Estrutura de Domínios (Domain-Driven Design)

No back-end isolaremos os pacotes para diminuir complexidades de herança e facilitar o isolamento por microserviços:
* `com.comunidade.identity.*` (Gerenciamento de usuários e perfis)
* `com.comunidade.catalog.*` (Catálogo de serviços e vitrine)
* `com.comunidade.notification.*` (Consumo de eventos e disparos de e-mail)

Usar enums como `Gender(MALE, FEMALE, OTHER)`, `UserStatus(PENDING, ACTIVE, SUSPENDED)` e `ServiceStatus(ACTIVE, INACTIVE, SUSPENDED)` para manter fidelidade com as regras de negócio.
