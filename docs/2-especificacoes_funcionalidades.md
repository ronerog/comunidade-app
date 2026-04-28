# Requisitos e Funcionalidades

Baseado no Documento de Requisitos Extraídos, o projeto é orientado aos três casos de uso (RFs) principais.

## 1. Cadastro de Clientes (Cidadãos/Solicitantes) - RF01
- **Descrição:** Requisito responsável pelo registro de usuários que desejam *solicitar* serviços na plataforma.
- **Campos Obrigatórios:** Nome Completo, CPF (validação exigida), Data de Nascimento, Gênero (1-Masculino, 2-Feminino, 3-Outro).
- **Acesso:** E-mail (único), Senha (mín. 8 caracteres, 1 maiúscula, 1 número, 1 caractere especial).
- **Endereço e Contato:** Celular, CEP (preenchimento automático de logradouro via Webservice do CEP), Logradouro, Número, Bairro, Município, Estado.
- **Documentação:** Foto de Perfil (armazenado como link), Anexo de Documento (Upload RG/CNH).
- **Regras:** CPF Validado; Status (Inclusão apenas após validar dados e e-mail de ativação); Alterações restritas ao próprio usuário.

## 2. Cadastro de Prestador de Serviço - RF02
- **Descrição:** Requisito para registro de profissionais ou voluntários que disponibilizarão mão de obra gratuitamente.
- **Campos Obrigatórios:** Nome/Razão Social, CPF ou CNPJ (validação exigida), Resumo/Biografia de habilidades, Categorias de Atuação (Ex: Limpeza, Elétrica), *Status*.
- **Endereço:** Utiliza a mesma malha do cliente (CEP via webservice).
- **Documentos:** Portfólios de expertise, Foto de Perfil, Anexo Documental (RG/CNH/MEI).
- **Regras:** Pode assumir diferentes Status (Ativo, Desativado, Suspenso), histórico mantido. Obrigatória vinculação a uma categoria ativa de atuação.

## 3. Criação de Serviço - RF03
- **Descrição:** Permite que o prestador crie anúncios na vitrine.
- **Requisito:** Prestador logado e ativo.
- **Dados do Serviço:** Título, Descrição Detalhada, Categoria (associada), Disponibilidade (Horários), Fotos ilustrativas (várias).
