# Project E-Commerce

## Description

An E-commerce web application using Java SpringBoot as Maven project which integrates PostgreSQL for database connection
and templating engine ThymeLeaf along Bootstrap.

## Features

- ### Admin Section

    - Categories
    - Products

- ### User Section

    - Google OAuth
    - Custom Auth
    - Role based auth
    - Products Page
    - Cart Management
    - Payment Gateway

[//]: # (    - Checkout)

## Prerequisites

- Java version 18+
- SpringBoot 2.2.x
- PostgreSQL 12.x
- Spring version 5.2.x
- Git version 2.x
- [Maven Dependencies](https://github.com/sthsuyash/Mitho-Confectionery/blob/main/pom.xml) for _pom.xml_

- Application.properties

 ```application.yml
    spring:
      jpa:
        database: POSTGRESQL
      show-sql: true
      hibernate:
        ddl-auto: update
    datasource:
      url: jdbc:postgresql://localhost:5432/{{db_name}}
      username: {{username}}
      password: {{password}}
      driverClassName: org.postgresql.Driver
    sql:
      init:
        platform: postgres
 ```

 <br/>

## Running the Application

- Clone the repository to your local device.

  ```git
  git clone https://github.com/sthsuyash/Mitho-Confectionery.git
  ```

- Configure the Application.properties file.

  _in the place of_ {{username}} _and_ {{password}} _, put your database username and password_

  ```properties
  spring.datasource.username=${USERNAME}
  spring.datasource.password=${PASSWORD}
  ```

- Run the Application using IntelliJ IDEA or STS.

  ```mvn
  mvn clean install
  ```

  ```mvn
  ./mvnw spring-boot:run
  ```

  <br/>

## Contributing

To contribute to this app

- First, fork the repository. Now there will be a copy of this repo in your account.
- Clone the repository in your account and make changes to your local repo

  ```git
  git clone ${your_repo_url}
  ```

- To add features to the main repository, open Pull Request.
  <br/>

## License

MIT License

Copyright (c) 2022 Suyash Shrestha

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
<br/>

[Comment]: <> (## Citation)

## Contact

- sthasuyash11@gmail.com
- [LinkedIn](https://www.linkedin.com/in/sthsuyash/)
