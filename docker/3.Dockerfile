FROM openjdk:8-jdk-alpine

VOLUME /tmp

ARG JAR_FILE=/build/libs/docker-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar /app.jar"]

# $ docker build -f 3.Dockerfile -t myorg/myapp:0.0.3 .
# && docker run
# -p 8083:8083
# --env JAVA_OPTS=-Dserver.port=8083
# --name myapp3
# myorg/myapp:0.0.3

# $ docker exec -i -t myapp3 /bin/sh
# / #
