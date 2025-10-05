FROM amazoncorretto:24-alpine-jdk
WORKDIR /app

COPY target/TrabajoAW-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]