
# Incidents records - BackEnd

# Requirements
    1- Java 21
    2- MVN 3.8+
    3- API Dog (REQS)
    4- PostBird (BD)
    5- Docker (img = postgresql)
    6- Spring-boot 3.4.5

# APIS
    /incident/create
    /incident/update
    /incident/delete/{idIncident}
    /incident/getbyid/{idIncident}
    /incident/getbyall
    /incident/getbyordertable

## Run Project
    0- port : 8080
    1- mvn -U  clean install
    2- mvn spring-boot:run

