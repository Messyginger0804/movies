#FROM java:17

# syntax=docker/dockerfile:1

FROM maven:3.8-openjdk-17 AS build
COPY . .
RUN mvn clean package -Dskiptest

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/movies-0.0.1-SNAPSHOT.jar demo.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "movies"]