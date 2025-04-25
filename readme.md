
# Incidents records - BackEnd

# Requirements
    0- Java 21
    1- MVN 3.9+
    2- API Dog (REQUESTS)
    3- PostBird (APP VISUAL BD)
    4- Docker (img = postgresql)
    5- Spring-boot 3.4.5

# APIS
    /incident/create
    /incident/update
    /incident/delete/{idIncident}
    /incident/getbyid/{idIncident}
    /incident/getbyall
    /incident/getbyordertable

## Run Project
    0- docker-compose up --build
    1- docker-compose up -d
    2- port : 8080
    3- mvn -U  clean install
    4- mvn spring-boot:run

