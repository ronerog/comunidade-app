# Modelo Entidade-Relacionamento (MER)

Este diagrama representa a estrutura necessária para englobar os casos **RF01 (Cliente)**, **RF02 (Prestador)** e **RF03 (Serviço)**. Como ambos Clientes e Prestadores acessam o sistema com "E-mail e Senha" e possuem formato de endereço virtualmente idênticos, utilizaremos uma base única e especializaremos suas funções através de perfis.

### Diagrama MER Completo

```mermaid
erDiagram
    USERS {
        uuid id PK
        string email "Único (Login)"
        string password_hash
        string first_name "Apenas Cidadão"
        string last_name "Apenas Cidadão"
        string company_name "Apenas Prestador"
        string document "CPF ou CNPJ (Único / Valido)"
        date birth_date "RF01"
        int gender_id "1-Masc, 2-Fem, 3-Outro"
        string mobile_phone "Celular"
        string profile_picture_url
        string document_anex_url "RG/CNH/MEI"
        int status_id "Ativo, Suspenso, etc"
        timestamp created_at
        timestamp updated_at
    }
    
    ADDRESSES {
        uuid id PK
        uuid user_id FK "1:1 com Users"
        string cep 
        string logradouro
        string number
        string bairro
        string city
        string state
    }

    PROVIDER_PROFILES {
        uuid user_id PK "1:1 com Users"
        string biography "Resumo de Habilidades"
    }

    CATEGORIES {
        int id PK
        string name "Ex: Limpeza, Elétrica"
    }

    SERVICES {
        uuid id PK
        uuid provider_id FK
        int category_id FK
        string title
        text description
        string availability "Horários Livres"
        int status "Ativo/Inativo"
        timestamp created_at
    }

    SERVICE_PHOTOS {
        uuid id PK
        uuid service_id FK
        string photo_url
    }

    %% Relações - Identity
    USERS ||--o| ADDRESSES : "reside em"
    USERS ||--o| PROVIDER_PROFILES : "se prestador, possui"
    
    %% Relações - Catalog
    PROVIDER_PROFILES ||--o{ SERVICES : "oferece"
    CATEGORIES ||--o{ SERVICES : "pertence a"
    SERVICES ||--o{ SERVICE_PHOTOS : "possui"
```

## Tratamento Base de Usuários
Esta tabela centralizada de `USERS` utiliza o conceito de *Single Table Strategy* para dados comuns, e tabelas associadas 1:1 (`ADDRESSES` e `PROVIDER_PROFILES`) para dados ramificados, mantendo uma rastreabilidade de histórico (Status) em todos os casos de acordo com os Requisitos Funcionais.
