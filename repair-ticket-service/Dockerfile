FROM openjdk:8
EXPOSE 8000
ADD target/repair-ticket-service-0.0.1-SNAPSHOT.jar repair-ticket-service.jar
ENTRYPOINT ["java","-jar","/repair-ticket-service.jar"]