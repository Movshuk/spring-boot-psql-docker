# PostgreSQL with Spring Boot on Docker
**using docker-compose file**

## Description:
1. get a list of data
2. add data
3. logging
4. automatic creation of the database during construction

## Tools and Technologies Used:
* Java 8+
* Maven 3.6.3
* Spring Boot 2.3.1.RELEASE
* Swagger 2.9.2
* PostgreSQL 12.2
* Docker 19.03.12
* Docker-compose 1.21.2

## How to run:
    mvn clean package
    sudo docker-compose up --build
    
## How to connect to 'myDb' use Terminal:
    sudo docker exec -it deal-psql psql -U postgres
    \connect myDb;
