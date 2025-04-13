# 📈 Simulador de Bolsa – Backend

Este é o backend do projeto **Simulador de Bolsa**, responsável por simular e fornecer, via API, dados de cotações fictícias em tempo real, além de gerenciar o histórico de variações dos ativos simulados.

---

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

## 📁 Estrutura de pastas

```
src
 └── main
     ├── java
     │   └── com.simuladorbolsa
     │       ├── controller     // Rotas da API
     │       ├── service        // Regras de negócio
     │       ├── model          // Modelos de dados
     │       ├── repository     // Interface com banco
     │       └── config         // Configurações gerais
     └── resources
         └── application.yml    // Configs do projeto
```

---

## ✅ Como rodar localmente

```bash
# Clone o repositório
git clone https://github.com/seu-usuario/simulador-bolsa-backend.git

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

## 🤝 Contribuição

1. Faça um fork do projeto
2. Crie uma branch: `git checkout -b minha-feature`
3. Commit com mensagem semântica
4. Push: `git push origin minha-feature`
5. Abra um Pull Request 🚀

---

## 🪪 Licença

Distribuído sob a licença **CC BY-NC 4.0**. Veja o arquivo [LICENSE](./LICENSE) para mais informações.

---

## 👤 Líder do projeto

**Diêgo de Barros Ferreira** — *Full Stack Tech Lead*

