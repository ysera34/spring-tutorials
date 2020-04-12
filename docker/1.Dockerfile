FROM openjdk:8-jdk-alpine

VOLUME /tmp

ARG JAR_FILE

# COPY target/*.jar app.jar
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]

# $ docker build
# --build-arg JAR_FILE=build/libs/docker-0.0.1-SNAPSHOT.jar
# -t myorg/myapp:0.0.1 .
# && docker run
# -p 8081:8080
# --name myapp1
# myorg/myapp:0.0.1

# $ docker exec -i -t myapp1 /bin/sh
# / #
