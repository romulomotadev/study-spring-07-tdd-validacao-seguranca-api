# TDD Validation and Security API
Desenvolvimento de endpoints REST utilizando a metodologia TDD (Test-Driven Development), incluindo tratamento global de exceções, regras de controle de acesso e validações.

## 🚀 Tecnologias Utilizadas
- Java 21
- Spring Boot
- Spring Security
- Spring Validation
- Maven
- JPA / Hibernate
- H2 Database


## 🎯 Objetivo do Projeto
Projeto desenvolvido com foco na aplicação da metodologia TDD (Test-Driven Development), implementando as funcionalidades necessárias nos endpoints REST, para gerenciamento de cidades e eventos, incluindo tratamento global, com regras de controle de acesso, e validações.


## 📁 Estrutura do Projeto

```
src/
└── main/
|  └── java/
|  | └── com.devsuperior.bds04/
|  |   └── config/
|  |   └── controller/
|  |   └── docs/
|  |   └── dto/  
|  |   └── entities/
|  |   └── exception/
|  |   └── handlers/
|  |   └── projection/
|  |   └── repository/
|  |   └── service/
|  |   └── Bds04Application.java
|  |
|  └── resources/
|  |   └── application.properties
|  |   └── application-test.properties
|  |   └── import.sql
|
└── test/
   └── java/
      └── controllers/
      └── tests/
```

## ⚙️ Como Executar

1. Clonar o repositório 
```
https://github.com/romulomotadev/study-spring-07-tdd-validacao-seguranca-api
```
2. Abra o projeto em sua IDE favorita (IntelliJ recomendado)
3. Execute a aplicação pela classe:
```
Bds04Application.java
```
4. Faça as requisições usando:
   
   - Postman
   - Insomnia
   - ThunderClient (VS Code)

5. Execute testes pelas classes:
```
CityControllerIT
EventControllerIT
```

O banco H2 é carregado automaticamente e um script import.sql popula os dados iniciais.

## 📌 Endpoints Principais


### 🔐 Login
```
POST /oauth2/token - autenticação e geração de token
```
### 🏙️ City
```
GET  /cities
POST /cities
```
### 🎫 Event
```
GET  /events
POST  /events
```

## 📄 Licença
Este projeto é apenas para fins de estudo e não possui fins comerciais.








