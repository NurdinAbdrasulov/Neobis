#FROM openjdk:8
#EXPOSE 8080
#ARG JAR_FILE=target/week11.jar
#ADD ${JAR_FILE} week11.jar
#ENTRYPOINT ["java","-jar","week11.jar"]

FROM openjdk:8-jdk-alpine as build
#VOLUME /tmp
WORKDIR /app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Build all the dependencies in preparation to go offline.
# This is a separate step so the dependencies will be cached unless
# the pom.xml file has changed.
RUN ./mvnw dependency:go-offline -B

COPY src src

RUN ./mvnw package -DskipTests
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

FROM openjdk:8-jre-alpine

ARG DEPENDENCY=/app/target/dependency

# Copy project dependencies from the build stage
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app


ENTRYPOINT ["java","-cp","app:app/lib/*","com.example.demo.DemoApplication"]
EXPOSE 8080
