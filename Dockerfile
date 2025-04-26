FROM openjdk:21-jdk AS build
ADD target/incidentRecords-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]