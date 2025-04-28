
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
# Actuator prometheus urls
    
http://localhost:8080/actuator/prometheus

http://localhost:9090/
## Grafana 
http://localhost:3000/

    login/senha = admin
    Home -> Connections -> Add new connection, choise Prometheus
    change connection for http://prometheus:9090 
    -> building a dashboard choise prometheus default
    -> find in Metric http_server_requests_seconds_count and Run queries.
---
# DB Conections run DB

    You can run the code with 2 databases, 
    postgresql using docker img and a dbeaver or postbird app 
    and you can run it with the h2 database by changing the properties configuration as well.

## POSTGRESQL 

### Run Project postgresql PostBird or dbeaver (DataBase Interface)
    0- docker-compose up -d
    1- mvn clean install
    2- mvn spring-boot:run

---
## H2

### Run Project H2 Database http://localhost:8080/h2-console
        
    0- use applicationh2 in main application 
    1- mvn clean install
    2- mvn spring-boot:run
    3- if you want to run prometheus with granafa on h2 use (docker-compose up -d (need docker app))

---
## Run APIS in Postman or Swagger http://localhost:8080/swagger-ui/index.html#/

### download ready json import Postman(https://drive.google.com/file/d/1SeWXzEoce_HyK-jnuB1_PgIyieXKTwL5/view?usp=sharing)








