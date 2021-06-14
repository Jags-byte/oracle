FROM openjdk:8
EXPOSE 8000
ADD target/notification-service-0.0.1-SNAPSHOT.jar notification-service.jar
ENTRYPOINT ["java","-jar","/notification-service.jar"]