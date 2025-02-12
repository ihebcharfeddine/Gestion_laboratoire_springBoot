FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/*.jar app.jar
COPY ./src/main/resources/myconfig /app/myconfig
ENTRYPOINT ["java","-jar","/app.jar"]
