
# Incidents records - BackEnd

# Requirements
    0- Java 21
    1- MVN 3.9+
    2- Spring-boot 3.4.5

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
    spring.datasource.url=jdbc:postgresql://localhost:5432/incident_record
    spring.datasource.username=admin
    spring.datasource.password=admin
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect


---
## H2 
### (DataBase Interface h2) http://localhost:8080/h2-console

    spring.datasource.url=jdbc:h2:mem:incident_record
    spring.datasource.driver-class-name=org.h2.Driver
    spring.datasource.username=sa
    spring.datasource.password=
    
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    spring.jpa.database-plataform=org.hibernate.dialect.H2Dialect
    
    spring.h2.console.enabled=true
    spring.h2.console.path=/h2-console
    
    security.token.secret=IncidentJava_@123#


---









