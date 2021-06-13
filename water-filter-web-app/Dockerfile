FROM openjdk:8
EXPOSE 8000
ADD target/currency-exchange-service-0.0.15-SNAPSHOT.jar currency-exchange.jar
ENTRYPOINT ["java","-jar","/currency-exchange.jar"]