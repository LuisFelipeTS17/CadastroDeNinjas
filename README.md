# Sistema de Cadastro de Ninjas

Bem-vindo ao **Sistema de Cadastro de Ninjas**!

Este projeto é uma aplicação desenvolvida com **Spring Boot** e estruturada em camadas, voltada ao cadastro de ninjas e ao gerenciamento de suas respectivas missões. A proposta do sistema é organizar entidades, relacionamentos e persistência de dados de forma simples, escalável e alinhada a boas práticas de desenvolvimento backend.

Além da aplicação principal, o projeto também contempla conteúdos extras sobre banco de dados, aprofundando conceitos relevantes para estudo e prática.

---

## Visão Geral do Projeto

O sistema foi desenvolvido para gerenciar **ninjas** e **missões**.

### Funcionalidades principais
- Cadastro de ninjas com:
  - nome
  - idade
  - e-mail
  - rank
- Atribuição de uma missão para um ninja
- Gerenciamento das missões e dos ninjas associados a elas

### Relacionamento entre entidades
- Um **Ninja** pode ser associado a **uma única Missão**
- Uma **Missão** pode estar associada a **vários Ninjas**

---

## Tecnologias Utilizadas

- **Spring Boot** — framework principal da aplicação
- **Spring Data JPA** — integração com o banco de dados
- **JPA (Java Persistence API)** — mapeamento objeto-relacional
- **H2 Database** — banco de dados em memória para desenvolvimento e testes
- **Flyway** — versionamento e migração de banco de dados
- **Maven** — gerenciamento de dependências e build do projeto
- **Git** — controle de versão
- **GitHub** — hospedagem do repositório
- **Docker** — apoio ao uso do banco de dados em ambiente externo
- **SQL** — manipulação e consulta de dados

---

## Design do Banco de Dados

A estrutura do banco de dados segue uma modelagem simples e organizada para representar ninjas e missões.

### Entidade Ninja
A entidade `Ninja` contém os seguintes atributos:
- `id`
- `nome`
- `idade`
- `email`
- `rank`

### Entidade Missão
A entidade `Missao` contém os seguintes atributos:
- `id`
- `titulo`
- `descricao`

### Relacionamento
- Um **Ninja** possui apenas **uma Missão**
- Uma **Missão** pode ser atribuída a **vários Ninjas**

---

## Requisitos

Antes de executar o projeto, verifique se você possui os seguintes itens instalados:

- **Java 17**
- **Maven**
- **Git**

---

## Configuração e Execução

### 1. Clone o repositório
```bash
git clone https://github.com/LuisFelipeTS17/CadastroDeNinjas.git
```

### 2. Acesse o diretório do projeto
```bash
cd CadastroDeNinjas
```

### 3. Compile o projeto
```bash
mvn clean install
```

### 4. Execute a aplicação
```bash
mvn spring-boot:run
```

### 5. Acesse a aplicação
```bash
http://localhost:8080
```

---

## Observações

- O projeto utiliza **H2 em memória**, portanto os dados podem ser reiniciados ao encerrar a aplicação, dependendo da configuração adotada.
- As migrações do banco são gerenciadas pelo **Flyway**.
- A organização em camadas facilita a manutenção, a escalabilidade e a evolução do sistema.
- O projeto também serve como base de estudos para conceitos de persistência, modelagem relacional e boas práticas com Spring Boot.

---

## Aprendizados do Projeto

Este projeto foi desenvolvido como apoio ao estudo de:

- arquitetura em camadas
- persistência de dados
- relacionamento entre entidades
- migrações com Flyway
- uso de banco em memória
- versionamento com Git e GitHub
- integração entre aplicação Java e banco de dados

---

## Autor

Projeto desenvolvido para fins de estudo e prática com **Spring Boot** e desenvolvimento backend.

