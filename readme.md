
# Incidents records - BackEnd

# Requirements
    0- Java 21
    1- MVN 3.9+
    3- Spring-boot 3.4.5

# APIS
    /incident/create
    /incident/update
    /incident/delete/{idIncident}
    /incident/getbyid/{idIncident}
    /incident/getbyall
    /incident/getbyordertable

## Run Project
    0- Docker (img = postgresql)
    1- docker-compose up --build
    2- docker-compose up -d
    3- port : 8080
    4- mvn clean install
    5- mvn spring-boot:run

---
# ROUTES JSON Postman
### download (https://drive.google.com/file/d/1uEIgNqEeMLTdi8QaV2t6yQoKNYuskvFi/view?usp=drive_link)

---
# DB Conections

## POSTGRESQL 

### PostBird or dbeaver (DataBase Interface)
    Docker (img = postgres:latest)
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
    spring.datasource.url=jdbc:postgresql://localhost:5432/incident_record
    spring.datasource.username=admin
    spring.datasource.password=admin
    spring.jpa.hibernate.ddl-auto=update

---
## H2 
### (DataBase Interface h2) http://localhost:8080/h2-console

    spring.datasource.url=jdbc:h2:mem:incident_record
    spring.datasource.username=sa
    spring.datasource.password=
    spring.jpa.hibernate.ddl-auto=update
    spring.datasource.driver-class-name=org.h2.Driver
    spring.jpa.show-sql=true
    spring.h2.console.enabled=true
    spring.h2.console.path=/h2-console


---
### MYSQL
###  dbeaver (DataBase Interface)
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.url=jdbc:mysql://incident_record:3306/incidentrecords_db?serverTimezone=UTC
    spring.datasource.username=root
    spring.datasource.password=root
    spring.jpa.hibernate.ddl-auto=update

# (commands for docker MYSQL)

    generating a jar to run through mysql with docker (Dockerfile)

    docker run -d -p 3308:3306 --name=incident_record --env="MYSQL_ROOT_PASSWORD=root" --env="MYSQL_PASSWORD=root" --env="MYSQL_DATABASE=incidentrecords_db" mysql:latest
    mvn clean install -DskipTests
    docker build -t incident-image .
    docker run -t --link incident_record:mysql -p 8080:8080 incident-image










