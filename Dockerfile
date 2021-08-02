FROM openjdk:11
MAINTAINER hmora@ciencias.unam.mx
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]