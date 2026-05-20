# build do projeto
FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /rede_solidaria

COPY pom.xml .

RUN mvn dependency:go-offline -B

COPY src ./src

RUN mvn clean package

# execucao do projeto
FROM eclipse-temurin:21-jdk-alpine

WORKDIR /rede_solidaria_app

COPY --from=build /rede_solidaria/target/*.jar rede_solidaria_app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "rede_solidaria_app.jar"]