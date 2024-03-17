# Authentication API

[<img src="https://run.pstmn.io/button.svg" alt="Run In Postman" style="width: 128px; height: 32px;">](https://app.getpostman.com/run-collection/16986858-92ef418e-1692-4e39-afdd-e1a04615b42b?action=collection%2Ffork&source=rip_markdown&collection-url=entityId%3D16986858-92ef418e-1692-4e39-afdd-e1a04615b42b%26entityType%3Dcollection%26workspaceId%3D86436409-99bf-4b1b-ba13-6b801eda220b)

This project is an example of API with authentication and authorization using Spring Security and JWT. It was built using Java, Spring Boot, Flyway Migrations and MySQL as the database. This project was based on the YouTube tutorial [Autenticação e Autorização com Spring Security e JWT Tokens](https://www.youtube.com/watch?v=5w-YCcOjPD0&ab_channel=FernandaKipper%7CDev).

## Table of contents

- [About](#authentication-api)
- [Requirements](#requirements)
- [Installation](#installation)
- [Authentication](#authentication)
- [Endpoints](#endpoints)
- [Author](#author)

## Requirements

- Java 20
- MySQL 8.0.34
- Maven

## Installation

1. Clone this repository:

```bash
$ git clone https://github.com/AnaBilecki/auth-api.git
```

2. Build the application:
   
```bash
mvn clean install
```

3. Run the application with Maven:
   
```bash
mvn spring-boot:run
```

4. The application will be accessible at [http://localhost:8080](http://localhost:8080).

## Authentication

There are two types of roles available in this API:

| Role          |  Description                            |
| ------------- | --------------------------------------- |
| USER          | Standard users for basic GET operations |
| ADMIN         | Users for managing operations           |

## Endpoints

This API provides the following endpoints:

| HTTP Method          |  Resource Path    | Description                      | Authentication          |
| -------------------- | ----------------- | -------------------------------- |------------------------ |
| GET                  |  /products        | Retrieve a list of all products  | All authenticated users |
| GET                  |  /products/{id}   | Retrieve a product by id         | All authenticated users |
| POST                 |  /products        | Insert a product                 | Only ADMIN users        |
| POST                 |  /users/register  | Register an user                 | Only ADMIN users        |
| POST                 |  /auth/login      | Login into the application       | All authenticated users |
| PUT                  |  /products/{id}   | Edit a product                   | Only ADMIN users        |
| DELETE               |  /products/{id}   | Delete a product by id           | Only ADMIN users        |

## Author

**Ana Carolina Bilecki** 

:woman_student: Software Engineering Student

<a href="https://github.com/AnaBilecki">
  <img src="https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white" />
</a>

<a href="https://linkedin.com/in/ana-carolina-bilecki">
  <img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white" />
</a>
