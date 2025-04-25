
# Incidents records - BackEnd

# Requirements
    0- Java 21
    1- MVN 3.9+
    2- API Dog (REQS)
    3- PostBird (BD)
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
    0- port : 8080
    1- mvn -U  clean install
    2- mvn spring-boot:run

