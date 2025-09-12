# Bolsa API - Arquitetura Monolítica Modular

## Estrutura de Pastas

```
bolsa-api-nest/
├── src/
│   ├── app.module.ts
│   ├── users/
│   ├── assets/
│   ├── portfolio/
│   ├── orders/
│   ├── simulation/
│   ├── auth/
│   └── common/
├── test/
├── Dockerfile
├── docker-compose.yml
├── docker-compose.dev.yml
├── docker-compose.prod.yml
├── .env
├── package.json
└── pnpm-lock.yaml
```

## Organização Modular

- Cada domínio (ex: `users`, `assets`, `orders`) tem seu próprio módulo, controller, service e modelos.
- Todos os módulos rodam juntos em uma única aplicação backend.
- Banco de dados compartilhado entre os módulos.

## Setup Docker (Desenvolvimento e Produção)

### 1. Instale o Docker
Se você nunca usou Docker, acesse https://www.docker.com/get-started/ e siga as instruções para baixar e instalar o Docker Desktop no seu sistema (Windows, Mac ou Linux). Após instalar, abra o Docker Desktop para garantir que está rodando.

### 2. Como rodar o projeto
Você não precisa instalar nada além do Docker para rodar o projeto!

- **Para ambiente de desenvolvimento:**
  ```sh
  docker-compose -f docker-compose.yml -f docker-compose.dev.yml up --build
  ```
  Isso irá baixar as dependências, criar os containers e iniciar o sistema pronto para desenvolvimento (api, banco de dados...). 
  Este é o ponto de entrada para o desenvolvimento. Roda a aplicação com ele e desenvolve a partir daí.
  

- **Para ambiente de produção:**
  ```sh
  docker-compose -f docker-compose.yml -f docker-compose.prod.yml up --build
  ```
  Isso irá rodar o sistema com as configurações de produção.

> Dica: Para parar tudo, use `Ctrl+C` no terminal e depois `docker-compose down` para remover os containers.

---


### Sobre arquivos `.keep`

Em alguns diretórios do projeto você encontrará arquivos chamados `.keep`. Eles existem apenas para garantir que a pasta seja versionada no Git, mesmo se estiver vazia. O arquivo `.keep` não afeta o funcionamento do sistema e pode ser ignorado por quem for usar ou desenvolver o projeto.

- **Desenvolvimento:**
  ```sh
  docker-compose -f docker-compose.yml -f docker-compose.dev.yml up --build
  ```
- **Produção:**
  ```sh
  docker-compose -f docker-compose.yml -f docker-compose.prod.yml up --build
  ```

---

> Arquitetura modular, organizada e fácil de escalar. Ideal para times pequenos e projetos em evolução.
