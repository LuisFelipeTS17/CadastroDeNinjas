<h1 align="center">🥷 Sistema de Cadastro de Ninjas</h1>

<p align="center">
  API REST desenvolvida com <strong>Spring Boot</strong> para o cadastro de ninjas e o gerenciamento de suas missões, estruturada em camadas e seguindo boas práticas de desenvolvimento backend.
</p>

<p align="center">
  <img alt="Java" src="https://img.shields.io/badge/Java-17-007396?style=for-the-badge&logo=openjdk&logoColor=white">
  <img alt="Spring Boot" src="https://img.shields.io/badge/Spring%20Boot-4.0-6DB33F?style=for-the-badge&logo=springboot&logoColor=white">
  <img alt="Maven" src="https://img.shields.io/badge/Maven-Build-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white">
  <img alt="H2" src="https://img.shields.io/badge/H2-Database-1021FF?style=for-the-badge&logo=h2&logoColor=white">
  <img alt="Flyway" src="https://img.shields.io/badge/Flyway-Migrations-CC0200?style=for-the-badge&logo=flyway&logoColor=white">
</p>

---

## 📌 Índice

- [Sobre o Projeto](#-sobre-o-projeto)
- [Tecnologias](#-tecnologias)
- [Arquitetura](#-arquitetura)
- [Modelagem de Dados](#-modelagem-de-dados)
- [Endpoints da API](#-endpoints-da-api)
- [Como Executar](#-como-executar)
- [Estrutura de Pastas](#-estrutura-de-pastas)
- [Aprendizados](#-aprendizados)
- [Autor](#-autor)

---

## 🎯 Sobre o Projeto

O **Sistema de Cadastro de Ninjas** é uma aplicação backend que expõe uma API REST para gerenciar **ninjas** e as **missões** a eles atribuídas.

A proposta é exercitar, de ponta a ponta, os pilares de uma aplicação Spring Boot: organização em camadas (`Controller → Service → Repository`), persistência com JPA, versionamento de banco com Flyway e operações **CRUD** completas.

### Funcionalidades

- ✅ Cadastro, listagem, atualização e remoção de **ninjas**
- ✅ Cadastro, listagem e remoção de **missões**
- ✅ Associação de um ninja a uma missão
- ✅ Migrações de banco versionadas com Flyway
- ✅ Console web do H2 para inspeção dos dados

---

## 🛠 Tecnologias

| Categoria | Ferramenta |
|-----------|-----------|
| Linguagem | **Java 17** |
| Framework | **Spring Boot 4** (Web, Data JPA) |
| Persistência | **Spring Data JPA / Hibernate** |
| Banco de dados | **H2 Database** |
| Migrações | **Flyway** |
| Produtividade | **Lombok** |
| Variáveis de ambiente | **spring-dotenv** |
| Build | **Maven** |
| Versionamento | **Git & GitHub** |

---

## 🧱 Arquitetura

A aplicação segue o padrão de **arquitetura em camadas**, separando responsabilidades para facilitar manutenção e testes:

```
┌─────────────┐     ┌─────────────┐     ┌──────────────┐     ┌──────────┐
│  Controller │ ──▶ │   Service   │ ──▶ │  Repository  │ ──▶ │  Banco   │
│  (rotas)    │     │  (regras)   │     │  (acesso)    │     │   (H2)   │
└─────────────┘     └─────────────┘     └──────────────┘     └──────────┘
```

- **Controller** — recebe as requisições HTTP e delega para o Service.
- **Service** — concentra as regras de negócio.
- **Repository** — abstrai o acesso ao banco via Spring Data JPA.
- **Model** — entidades JPA mapeadas para as tabelas.

---

## 🗄 Modelagem de Dados

### Entidade `Ninja` — `tb_cadastro`

| Campo     | Tipo   | Descrição                          |
|-----------|--------|------------------------------------|
| `id`      | Long   | Identificador único (PK)           |
| `nome`    | String | Nome do ninja                      |
| `email`   | String | E-mail (único)                     |
| `imgUrl`  | String | URL da imagem do ninja             |
| `idade`   | int    | Idade do ninja                     |
| `missoes` | Missao | Missão associada (FK `missoes_id`) |

### Entidade `Missao` — `tb_missoes`

| Campo         | Tipo        | Descrição                          |
|---------------|-------------|------------------------------------|
| `id`          | Long        | Identificador único (PK)           |
| `nome`        | String      | Nome da missão                     |
| `dificuldade` | String      | Nível de dificuldade               |
| `ninjas`      | List<Ninja> | Ninjas atribuídos à missão         |

### Relacionamento

> Uma **Missão** pode ter **vários Ninjas** (`@OneToMany`), enquanto cada **Ninja** pertence a **uma única Missão** (`@ManyToOne`).

```
Missao (1) ───────< (N) Ninja
```

---

## 🌐 Endpoints da API

Base URL: `http://localhost:8080`

### 🥷 Ninjas — `/ninjas`

| Método   | Rota             | Descrição                       |
|----------|------------------|---------------------------------|
| `GET`    | `/listar`        | Lista todos os ninjas           |
| `GET`    | `/listar/{id}`   | Busca um ninja por ID           |
| `POST`   | `/criar`         | Cadastra um novo ninja          |
| `PUT`    | `/alterar/{id}`  | Atualiza um ninja existente     |
| `DELETE` | `/deletar/{id}`  | Remove um ninja por ID          |

**Exemplo de corpo (`POST /ninjas/criar`):**

```json
{
  "nome": "Naruto Uzumaki",
  "email": "naruto@konoha.com",
  "imgUrl": "https://exemplo.com/naruto.png",
  "idade": 17,
  "missoes": { "id": 1 }
}
```

### 🎯 Missões — `/missoes`

| Método   | Rota             | Descrição                       |
|----------|------------------|---------------------------------|
| `GET`    | `/listar`        | Lista todas as missões          |
| `GET`    | `/listar/{id}`   | Busca uma missão por ID         |
| `POST`   | `/criar`         | Cadastra uma nova missão        |
| `DELETE` | `/deletar/{id}`  | Remove uma missão por ID        |

**Exemplo de corpo (`POST /missoes/criar`):**

```json
{
  "nome": "Resgatar o Kazekage",
  "dificuldade": "Rank S"
}
```

---

## ▶ Como Executar

### Pré-requisitos

- [Java 17](https://www.oracle.com/java/technologies/downloads/)
- [Maven](https://maven.apache.org/)
- [Git](https://git-scm.com/)

### Passo a passo

```bash
# 1. Clone o repositório
git clone https://github.com/LuisFelipeTS17/CadastroDeNinjas.git

# 2. Acesse o diretório
cd CadastroDeNinjas

# 3. Compile o projeto
mvn clean install

# 4. Execute a aplicação
mvn spring-boot:run
```

A aplicação ficará disponível em **`http://localhost:8080`**.

### Variáveis de ambiente

A conexão com o banco usa variáveis carregadas de um arquivo `.env` na raiz do projeto:

```env
DATABASE_URL=jdbc:h2:file:./data/cadastroDeNinjasDb
DATABASE_USERNAME=sa
DATABASE_PASSWORD=
```

### Console do H2

Com a aplicação rodando, acesse o console web do banco em:

```
http://localhost:8080/h2-console
```

---

## 📁 Estrutura de Pastas

```
CadastroDeNinjas
├── src/main/java/dev/java10x/cadastroDeNinjas
│   ├── CadastroDeNinjasApplication.java   # Classe principal
│   ├── Ninjas
│   │   ├── NinjaController.java           # Camada de rotas
│   │   ├── NinjaService.java              # Regras de negócio
│   │   ├── NinjaRepository.java           # Acesso a dados
│   │   └── NinjaModel.java                # Entidade JPA
│   └── Missoes
│       ├── MissoesController.java
│       ├── MissoesService.java
│       ├── MissoesRepository.java
│       └── MissoesModel.java
├── src/main/resources
│   ├── application.properties             # Configurações
│   └── db/migrations                      # Scripts Flyway (V__*.sql)
└── pom.xml                                # Dependências e build
```

---

## 📚 Aprendizados

Este projeto consolidou conhecimentos em:

- Arquitetura em camadas com Spring Boot
- Operações **CRUD** com Spring Data JPA
- Mapeamento de relacionamentos (`@OneToMany` / `@ManyToOne`)
- Versionamento de banco de dados com **Flyway**
- Uso de **Lombok** para reduzir boilerplate
- Configuração via variáveis de ambiente (`.env`)
- Versionamento de código com **Git & GitHub**

---

## 👤 Autor

Projeto desenvolvido por **Luis Felipe** para fins de estudo e prática com **Spring Boot** e desenvolvimento backend.

<p align="center">
  <sub>⭐ Se este projeto te ajudou, considere deixar uma estrela no repositório!</sub>
</p>
