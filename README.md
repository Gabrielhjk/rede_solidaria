## 📌 Sobre o Projeto

A ideia central é um sistema onde usuários possam cadastrar doações e encontrar itens disponíveis de forma simples e organizada.


---

## 🚀 Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL
- Maven
- Lombok
- REST API



---

## 📂 Estrutura do Projeto

```
src/
└── main
    └── java/rede_solidaria
        ├── controller
        ├── config
        ├── database
        │   ├── model
        │   │   └── enums
        │   └── repository
        ├── dto
        ├── handler
        └── service
```


---


assets/projeto_java.png



---


## 📦 Funcionalidades

### Funcionalidades do Administrador (Admin)

#### Beneficiários
- Listar todos os beneficiários
- Cadastrar novos beneficiários
- Excluir beneficiários
- Filtrar beneficiários por nível de prioridade:
  - URGENTE
  - ALTA
  - MÉDIA
  - BAIXA
  
#### Doadores
- Listar todos os doadores
- Cadastrar novos doadores
- Excluir doadores

### Funcionalidades do Beneficiário

#### Doadores
- Listar todos os doadores cadastrados
- Visualizar dados de um doador específico

#### Itens de Doação
- Listar todos os itens disponíveis para doação
- Buscar item por ID
- Filtrar itens por status

#### Solicitações
- Solicitar itens de doação
- Listar solicitações realizadas

#### Atualização de perfil
- Atualizar dados pessoais do beneficiário

### Funcionalidades do Doador

#### Itens de Doação
- Cadastrar novos itens para doação
- Listar itens cadastrados
- Buscar item por ID
- Atualizar dados de itens
- Excluir itens de doação
- Atualizar status do item
  
#### Solicitações de Doação
- Aprovar solicitações de beneficiários
- Rejeitar solicitações de beneficiários

#### Fluxo de Doação
- Doador cadastra itens disponíveis
- Beneficiário visualiza e solicita itens
- Solicitação é registrada no sistema
- Doador aprova ou rejeita a solicitação
- Status do item é atualizado automaticamente

### Regras de Negócio
Beneficiários possuem níveis de prioridade:
  - URGENTE
  - ALTA
  - MÉDIA
  - BAIXA 
- Itens possuem controle de status
- Solicitações dependem da aprovação do doador


---


## ⚙️ Como executar o projeto

### 1. Clone o repositório
```
git clone https://github.com/Gabrielhjk/rede_solidaria.git
```

### 2. Acesse o diretório
```
cd rede_solidaria
```

### 3. Configure o banco de dados
```
acesse a pasta: src/main/resources/application.properties

spring.datasource.url=jdbc:mysql://localhost:3306/rede_solidaria
spring.datasource.username=root
spring.datasource.password=senha
spring.jpa.hibernate.ddl-auto=update
```

### 4. Adicione no .ENV
```
base_url = http://localhost:8080
pgadmin_url = http://localhost:5050

#variaveis de ambiente do postgres
DATABASE_USERNAME=postgres
DATABASE_PASSWORD=root
DATABASE_DB=rede_solidaria

#variaveis de ambiente do pgadmin4
PGADMIN_DEFAULT_EMAIL = admin@admin.com
PGADMIN_DEFAULT_PASSWORD = admin
```

### 5. Construa a imagem docker e roda o projeto
```
docker compose up --build -d
```

### 6. Acesse o Swagger
```
http://localhost:8080/swagger-ui/index.html
```

### 7. Para acessar o PGAdmin acesse
```
localhost:5050/login

Entre com os dados que estão no .ENV
```


---


## 📌 Observações

Este projeto foi desenvolvido para fins de estudos em:

Desenvolvimento Backend

Arquitetura MVC

APIs REST

Java

SpringBoot

---

#### ESSE REAME FOI GERADO COM AUXÍLIO DE INTELIGÊNCIA ARTIFICIAL (CHATGPT)
