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

## Setup Rápido

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
