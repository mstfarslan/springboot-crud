FROM openjdk:17 AS build

COPY pom.xml mvnw ./
COPY .mvn .mvn
RUN ./mvnw dependency:resolve

COPY src src
RUN ./mvnw package

FROM openjdk:17
WORKDIR springboot-backend
COPY --from=build target/*.jar springboot-backend.jar
ENTRYPOINT ["java", "-jar", "springboot-backend.jar"]
