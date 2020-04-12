FROM openjdk:8-jdk-alpine

VOLUME /tmp

COPY /bin/run.sh .
COPY /build/libs/docker-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["./run.sh"]

# $ docker build -f 2.Dockerfile -t myorg/myapp:0.0.2 .
# && docker run
# -p 8082:8080
# --name myapp2
# myorg/myapp:0.0.2

# $ docker exec -i -t myapp2 /bin/sh
# / #
