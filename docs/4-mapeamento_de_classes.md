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
```

## Estrutura de Domínios (Domain-Driven Design)

No back-end isolaremos os pacotes para diminuir complexidades de herança:
* `br.com.comunidade.identity.*`
* `br.com.comunidade.catalog.*`

Usar enums como `Gender(MALE, FEMALE, OTHER)` e `UserStatus(PENDING, ACTIVE, SUSPENDED)` para manter fidelidade com as flags requeridas nos RF01/RF02/RF03.
