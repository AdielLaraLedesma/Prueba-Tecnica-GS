FROM openjdk:21-jdk-slim-bullseye

USER root

##Variables de conexión para SQL SERVER
ENV SQL_SERVER_BOOTSTRAP sqlserver
ENV SQL_SERVER_BOOTSTRAP_PORT 1433
ENV SQL_SERVER_DB_NAME creditDB
ENV SQL_SERVER_USERNAME creditUser
ENV SQL_SERVER_PASSWORD seCret01*1

##Variables de cors del frontend
ENV FRONTEND_ORIGIN http://localhost

ENV SERVER_PORT 8080

RUN mkdir -p /app

WORKDIR /app

ADD /target/prueba-tecnica-backend-0.0.1-SNAPSHOT.jar app.jar

RUN chmod a+x /app/app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
