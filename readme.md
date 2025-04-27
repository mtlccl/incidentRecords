
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

---
# DB Conections run DB

    You can run the code with 2 databases, 
    postgresql using docker img and a dbeaver or postbird app 
    and you can run it with the h2 database by changing the properties configuration as well.

## POSTGRESQL 

### Run Project postgresql PostBird or dbeaver (DataBase Interface)
    0- Docker (need docker app, img = postgresql, dbeaver app or postbird app)
    1- docker run --name incidentdb -e POSTGRES_PASSWORD=admin -d postgres
    2- docker-compose up -d
    3- mvn clean install
    4- mvn spring-boot:run

---
## H2

### Run Project H2 Database http://localhost:8080/h2-console
        
    0- change propierts main for applicationh2
    1- mvn clean install
    2- mvn spring-boot:run

---
## Run APIS in Postman or Swagger http://localhost:8080/swagger-ui/index.html#/

### download ready json import Postman(https://drive.google.com/file/d/1SeWXzEoce_HyK-jnuB1_PgIyieXKTwL5/view?usp=sharing)








