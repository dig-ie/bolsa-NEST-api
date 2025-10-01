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

### 2. Setup Rápido (Recomendado)

**Windows:**

```cmd
scripts\setup-dev.bat
```

**Linux/Mac:**

```bash
chmod +x scripts/setup-dev.sh
./scripts/setup-dev.sh
```

Este script irá:

- Criar o arquivo `.env` automaticamente
- Parar containers existentes
- Iniciar o banco de dados e API
- Aplicar as migrações do Prisma
- Verificar se tudo está funcionando

### 3. Setup Manual

Se preferir fazer manualmente:

1. **Crie o arquivo `.env`:**

```bash
# Configurações do Banco de Dados
DATABASE_URL="postgresql://user:bolsa2024!@localhost:5433/bolsa_sim?schema=public"

# Configurações da Aplicação
NODE_ENV=development
PORT=3000

# Configurações do Prisma
PRISMA_GENERATE_DATAPROXY=false
```

2. **Inicie os containers:**

```bash
docker-compose -f docker-compose.dev.yml up --build -d
```

3. **Aplique as migrações:**

```bash
docker-compose -f docker-compose.dev.yml exec api npx prisma migrate deploy
```

### 4. Verificação

- **API:** http://localhost:3000
- **Prisma Studio:** http://localhost:5555 (interface gráfica do banco)
- **Banco:** localhost:5433 (user: `user`, password: `bolsa2024!`, database: `bolsa_sim`)

### 5. Dados de Teste

O sistema cria automaticamente usuários de teste:

- **Admin:** admin@bolsa.com / admin123
- **Usuário:** test@bolsa.com / test123

### 6. Comandos Úteis

```bash

# Entrypoints do projeto:
# Windows
scripts/setup-dev.bat
# Linux/Mac
scripts/setup-dev.sh


# Ver logs
docker-compose -f docker-compose.dev.yml logs -f

# Parar tudo
docker-compose -f docker-compose.dev.yml down

# Resetar banco (remove todos os dados)
docker-compose -f docker-compose.dev.yml down -v

# Acessar container da API
docker-compose -f docker-compose.dev.yml exec api sh

# Executar comandos Prisma
docker-compose -f docker-compose.dev.yml exec api npx prisma studio

# Abrir Prisma Studio (se não estiver rodando)
docker-compose -f docker-compose.dev.yml up prisma-studio

# Executar seed manualmente
docker-compose -f docker-compose.dev.yml exec api npx prisma db seed


```

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
