# 📈 Simulador de Bolsa – Backend

Este é o backend do projeto **Simulador de Bolsa**, responsável por simular e fornecer, via API, dados de cotações fictícias em tempo real, além de gerenciar o histórico de variações dos ativos simulados.

---

## Responsabilidades do Backend:
📁 Backend & Banco de Dados
Foco na persistência de dados importantes utilizando Spring Boot e PostgreSQL.</br>

✅ Principais Funcionalidades:</br>
🔐 1. Autenticação e Gerenciamento de Usuários</br>
📊 2. Histórico de Simulações</br>
Responsável por registrar e armazenar o histórico completo de simulações feitas pelo usuário.</br>

## 🚀 Tecnologias utilizadas

- ☕ **Java 17+**
- 🧩 **Spring Boot**
- 🔁 **Kafka (simulação de streaming interno)**
- 🌐 **REST API**
- 🗃️ **H2** ou **PostgreSQL** (ajustável)
- 📦 **Maven**

---

## 📦 Funcionalidades

- Simulação de cotações em tempo real com atualização a cada segundo
- Endpoints RESTful para consulta de dados de ativos
- Histórico de variação de preços
- Integração com front-end via JSON
- Ambiente pronto para testes e expansão

---

```

---

## ✅ Como rodar localmente

```bash
# Clone o repositório
git clone https://github.com/dig-ie/simulador-bolsa-backend.git

# Acesse o diretório
cd simulador-bolsa-backend

# Rode a aplicação
./mvnw spring-boot:run
```

A aplicação será iniciada em: `http://localhost:8080`

---

## 🔄 Rotas principais

| Método | Endpoint            | Descrição                          |
|--------|---------------------|------------------------------------|
| GET    | /api/prices         | Retorna as cotações atuais         |
| GET    | /api/history        | Retorna histórico dos ativos       |
| GET    | /api/assets         | Lista os ativos simulados          |

---

## 📦 Commit Semântico (Padrão de mensagens)

| Tipo       | Uso                                                       |
|------------|-----------------------------------------------------------|
| `feat`     | Nova funcionalidade                                       |
| `fix`      | Correção de bug                                           |
| `refactor` | Refatoração de código (sem mudança de comportamento)      |
| `style`    | Ajustes visuais ou de formatação (sem lógica envolvida)   |
| `docs`     | Documentação adicionada ou atualizada                     |
| `test`     | Adição ou modificação de testes                           |
| `chore`    | Tarefas auxiliares (configs, dependências, etc.)          |

---

🚧 Em desenvolvimento
Este projeto ainda está em fase inicial e será evoluído continuamente, com foco em performance, usabilidade e dados em tempo real.

## 🪪 Licença

Distribuído sob a licença **CC BY-NC 4.0**. Veja o arquivo [LICENSE](./LICENSE) para mais informações.

---

## 👤 Líder do projeto

**Diêgo de Barros Ferreira** — *Full Stack Tech Lead* <br/>
**Brenno Felipe** — *Backend developer* <br/>
**Camilo Ariel** — *Backend developer* <br/>
